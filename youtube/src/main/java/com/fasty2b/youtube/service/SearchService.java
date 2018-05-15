/*
 * Copyright (c) 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.fasty2b.youtube.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.util.DateTime;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;
import com.fasty2b.youtube.dto.SearchVideoSetting;
import com.fasty2b.youtube.entity.ResponseEntity;
import com.fasty2b.youtube.entity.VideoInfo;
import com.fasty2b.youtube.utils.Auth;
import com.fasty2b.youtube.utils.Constants;

/**
 * Print a list of videos matching a search term.
 *
 * @author Thong
 */
@Service
public class SearchService {

    /**
     * Define a global variable that identifies the name of a file that
     * contains the developer's API key.
     */
    private static final String PROPERTIES_FILENAME = "youtube.properties";

    private static final long NUMBER_OF_VIDEOS_RETURNED = 25;

    /**
     * Define a global instance of a Youtube object, which will be used
     * to make YouTube Data API requests.
     */
    private static YouTube youtube;

    /**
     * Initialize a YouTube object to search for videos on YouTube. Then
     * display the name and thumbnail image of each video in the result set.
     *
     * @param args command line args.
     */
    public ResponseEntity<List<VideoInfo>> searchVideo(String videoName, SearchVideoSetting setting) {
        // Read the developer key from the properties file.
        Properties properties = new Properties();
        try {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTIES_FILENAME);
            properties.load(in);

        } catch (IOException e) {
            return new ResponseEntity<>(Constants.ERROR_CODE, "There was an error reading " + PROPERTIES_FILENAME + ": " + e.getCause()
            + " : " + e.getMessage());
        }

        try {
            // This object is used to make YouTube Data API requests. The last
            // argument is required, but since we don't need anything
            // initialized when the HttpRequest is initialized, we override
            // the interface and provide a no-op function.
            youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, new HttpRequestInitializer() {
                public void initialize(HttpRequest request) throws IOException {
                }
            }).setApplicationName("youtubetool").build();

            // Prompt the user to enter a query term.

            // Define the API request for retrieving search results.
            YouTube.Search.List search = youtube.search().list("id,snippet");

            // Set your developer key from the {{ Google Cloud Console }} for
            // non-authenticated requests. See:
            // {{ https://cloud.google.com/console }}
            String apiKey = properties.getProperty("youtube.apikey");
            search.setKey(apiKey);
            search.setQ(videoName);

            // Restrict the search results to only include videos. See:
            // https://developers.google.com/youtube/v3/docs/search/list#type
            search.setType("video");

            // To increase efficiency, only retrieve the fields that the
            // application uses.
            search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
            search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);
            // modify search conditions
            if(setting != null) {
            	if(StringUtils.isNotEmpty(setting.getEventType())) {
            		search.setEventType(setting.getEventType());
            	}
            	if(StringUtils.isNotEmpty(setting.getOrder())) {
            		search.setOrder(setting.getOrder());
            	}
            	
            	if(StringUtils.isNotEmpty(setting.getVideoDefinition())) {
            		search.setVideoDefinition(setting.getVideoDefinition());
            	}
            	
            	if(StringUtils.isNotEmpty(setting.getVideoDuration())) {
            		search.setVideoDuration(setting.getVideoDuration());
            	}
            	
            	if(StringUtils.isNotEmpty(setting.getVideoType())) {
            		search.setVideoType(setting.getVideoType());
            	}
            	
            	
            	Random rn = new Random();            	
            	long maxResults =  rn.nextInt(setting.getMaxResults() - setting.getMinResults() + 1) + setting.getMinResults();
            	if(maxResults > 0) {
            		search.setMaxResults(maxResults);
            	} else {
            		search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);
            	}
            	
            	int date = setting.getPublishedAfter();
            	if(date != -1) {
            		Calendar cal = Calendar.getInstance();
                	cal.add(Calendar.DATE, -date);            	
                	DateTime publishedAfter = new DateTime(cal.getTime());
                	search.setPublishedAfter(publishedAfter);
            	}
            	
            	
            }

            // Call the API and print results.
            SearchListResponse searchResponse = search.execute();
            List<SearchResult> searchResultList = searchResponse.getItems();
            if (searchResultList != null) {
            	return new ResponseEntity<List<VideoInfo>>(0, Constants.SUCCESS, getVideoInfos(searchResultList.iterator(), videoName));
            } else {
            	return new ResponseEntity<List<VideoInfo>>(0, Constants.SUCCESS, new ArrayList<VideoInfo>());
            }
        } catch (GoogleJsonResponseException e) {
            return new ResponseEntity<List<VideoInfo>>(Constants.ERROR_CODE, "There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
            return new ResponseEntity<List<VideoInfo>>(Constants.ERROR_CODE, "There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
        	return new ResponseEntity<List<VideoInfo>>(Constants.ERROR_CODE, "There was an IO error: " + t.getCause() + " : " + t.getMessage());
        }
    }

    /*
     * Prints out all results in the Iterator. For each result, print the
     * title, video ID, and thumbnail.
     *
     * @param iteratorSearchResults Iterator of SearchResults to print
     *
     * @param query Search query (String)
     */
    private static List<VideoInfo> getVideoInfos(Iterator<SearchResult> iteratorSearchResults, String query) {
    	List<VideoInfo> videoInfos = new ArrayList<>();
        while (iteratorSearchResults.hasNext()) {

            SearchResult singleVideo = iteratorSearchResults.next();
            ResourceId rId = singleVideo.getId();

            // Confirm that the result represents a video. Otherwise, the
            // item will not contain a video ID.
            if (rId.getKind().equals("youtube#video")) {
                Thumbnail thumbnail = singleVideo.getSnippet().getThumbnails().getDefault();
                videoInfos.add(new VideoInfo(rId.getVideoId(), singleVideo.getSnippet().getTitle(), thumbnail.getUrl()));
            }
        }
        
        return videoInfos;
    }
}
