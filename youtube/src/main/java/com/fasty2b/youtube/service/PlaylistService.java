/*
 * Copyright (c) 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fasty2b.youtube.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasty2b.youtube.dto.AccessTokenInfo;
import com.fasty2b.youtube.dto.AuthDTO;
import com.fasty2b.youtube.dto.Channel;
import com.fasty2b.youtube.dto.ChannelInfo;
import com.fasty2b.youtube.dto.ChannelResponse;
import com.fasty2b.youtube.dto.DescriptionSetting;
import com.fasty2b.youtube.dto.GeneralSetting;
import com.fasty2b.youtube.dto.InsertVideoSetting;
import com.fasty2b.youtube.dto.PlayList;
import com.fasty2b.youtube.dto.PlayListInfoDTO;
import com.fasty2b.youtube.dto.RefreshToken;
import com.fasty2b.youtube.dto.SearchVideoSetting;
import com.fasty2b.youtube.dto.TitleSetting;
import com.fasty2b.youtube.dto.VideoInfo;
import com.fasty2b.youtube.entity.ChannelBasicInfo;
import com.fasty2b.youtube.entity.Token;
import com.fasty2b.youtube.entity.User;
import com.fasty2b.youtube.utils.Auth;
import com.fasty2b.youtube.utils.Constants;
import com.google.api.client.auth.oauth2.TokenResponseException;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTubeRequestInitializer;
import com.google.api.services.youtube.model.Playlist;
import com.google.api.services.youtube.model.PlaylistItem;
import com.google.api.services.youtube.model.PlaylistItemSnippet;
import com.google.api.services.youtube.model.PlaylistListResponse;
import com.google.api.services.youtube.model.PlaylistSnippet;
import com.google.api.services.youtube.model.PlaylistStatus;
import com.google.api.services.youtube.model.ResourceId;
import com.google.common.collect.Lists;

/**
 * Creates a new, private playlist in the authorized user's channel and add a
 * video to that new playlist.
 *
 * @author Thong
 */
@Service
public class PlaylistService {

	private static final String REDIRECT_URI = "http://fasty2b.com:8080/autoplaylist/dashboard";

	//private static final String REDIRECT_URI = "http://localhost:8080/callback";

	// private static final String REDIRECT_URI =
	// "http://localhost:8080/autoplaylist/callback";

	/**
	 * Define a global instance of a Youtube object, which will be used to make
	 * YouTube Data API requests.
	 */
	private static YouTube youtube;

	private static final Logger logger = LogManager.getLogger(PlaylistService.class);

	/**
	 * Define a global variable that identifies the name of a file that contains the
	 * developer's API key.
	 */
	private static final String PROPERTIES_FILENAME = "youtube.properties";

	@Autowired
	ITokenService tokenService;

	@Autowired
	private SearchService searchService;
	
	@Autowired
	private IChannelBasicInfoService channelBasicInfoService;
	
	
	@Autowired
	private IUserService userService;

	public PlayListInfoDTO createPlayListAndAddVideos(PlayListInfoDTO playlistInfo,
			SearchVideoSetting searchSetting, TitleSetting titleSetting, DescriptionSetting descriptionSetting,
			GeneralSetting generalSetting, InsertVideoSetting insertVideoSetting)
			throws GoogleJsonResponseException, IOException, Exception, Throwable {
		// search Video
		com.fasty2b.youtube.dto.ResponseDTO<List<VideoInfo>> videoInfosResponse = searchService
				.searchVideo(playlistInfo.getTitle(), searchSetting);
		List<VideoInfo> VideoInfoEntities = videoInfosResponse.getData();

		// handle general setting
		if (generalSetting != null && StringUtils.isNotEmpty(generalSetting.getPrivacy())) {
			playlistInfo.setPrivacy(generalSetting.getPrivacy());
		} else {
			playlistInfo.setPrivacy("public");
		}

		// build description
		String description = "";
		if (descriptionSetting != null) {

			String videoTitleDecription = "";
			if (descriptionSetting.getIsAddRandomVideoTitle() == true) {
				StringBuilder builderDescription = new StringBuilder();
				int max = VideoInfoEntities.size() > 5 ? 5 : VideoInfoEntities.size();
				for (int i = 0; i < max; i++) {
					builderDescription.append(VideoInfoEntities.get(i).getTitle() + "\n");
					//VideoInfoEntities.get(i).getUrl()
				}
				

				videoTitleDecription = builderDescription.toString();
			}

			if (descriptionSetting.getIsAutoAddDescription()) {

				String sample1 = Constants.DESCRIPTION_ONE_CONSTANTS
						.get((int) (Math.random() * Constants.DESCRIPTION_ONE_CONSTANTS.size()));
				String sample2 = Constants.DESCRIPTION_TWO_CONSTANTS
						.get((int) (Math.random() * Constants.DESCRIPTION_TWO_CONSTANTS.size()));

				String sample3 = Constants.DESCRIPTION_THREE_CONSTANTS
						.get((int) (Math.random() * Constants.DESCRIPTION_THREE_CONSTANTS.size()));

				String sample4 = Constants.DESCRIPTION_FOUR_CONSTANTS
						.get((int) (Math.random() * Constants.DESCRIPTION_FOUR_CONSTANTS.size()));

				String sample5 = Constants.DESCRIPTION_FIVE_CONSTANTS
						.get((int) (Math.random() * Constants.DESCRIPTION_FIVE_CONSTANTS.size()));

				description = sample1 + sample2 + "\n" + videoTitleDecription + "\n" + sample3 + "\n" + sample4 + "\n"
						+ sample5;

			} else {
				description = descriptionSetting.getDescription();
				if (descriptionSetting.getIsAddRandomVideoTitle() == true) {
					description = description + "\n" + videoTitleDecription;
				}
			}

		}

		// build title this each play list

		String specialCharacter = "";
		List<String> specialCharacters = new ArrayList<>();
		specialCharacters.add("|");
		specialCharacters.add("-");
		specialCharacters.add("\u2665");
		specialCharacters.add("~");
		specialCharacters.add("\u2605");

		String concatWord = titleSetting.getConcatKeyword();
		if (StringUtils.equalsIgnoreCase(concatWord, "doc")) {
			specialCharacter = "|";
		} else if (StringUtils.equalsIgnoreCase(concatWord, "ngang")) {
			specialCharacter = "-";
		} else if (StringUtils.equalsIgnoreCase(concatWord, "tim")) {
			specialCharacter = "\u2665";
		} else if (StringUtils.equalsIgnoreCase(concatWord, "nga")) {
			specialCharacter = "~";
		} else if (StringUtils.equalsIgnoreCase(concatWord, "sao")) {
			specialCharacter = "\u2605";
		} else if (StringUtils.equalsIgnoreCase(concatWord, "ngaunhien")) {
			specialCharacter = specialCharacters.get((int) Math.random() * specialCharacters.size());
		}

		String playListName = playlistInfo.getTitle();
		if (titleSetting != null) {
			// add random keyword
			if (titleSetting.getIsAddRandomKeyWord() == true) {
				String randomWord = Constants.RANDOM_KEYWORDS_CONSTANTS
						.get((int) (Math.random() * Constants.RANDOM_KEYWORDS_CONSTANTS.size()));
				playListName = playListName + specialCharacter + randomWord;
			}

			// add random number into Title
			if (titleSetting.getIsAddRandomNumber() == true) {
				playListName = playListName + specialCharacter
						+ RandomStringUtils.randomNumeric(titleSetting.getNumber());
			}

		}

		// update title and description for new PLL
		playlistInfo.setTitle(playListName);
		playlistInfo.setDescription(description);

		PlayListInfoDTO addingPlaylistResult = addPlayList(playlistInfo);
		if (addingPlaylistResult == null) {
			return null;
		} else {
			// Insert and get playlist id
			String playlistId = addingPlaylistResult.getId();
			// get list of videos by playlistName

			// Insert videos into playlist
			int videoNumber = 0;
			for (VideoInfo video : VideoInfoEntities) {
				insertPlaylistItem(playlistId, video.getId());
				videoNumber++;
				if (addingPlaylistResult == null) {
					return null;
				}
			}
			addingPlaylistResult.setVideoNumber(videoNumber);

			// testing

			if (insertVideoSetting != null) {
				String videoId = "";
				// set default position = 0;
				Long position = new Long(0);
				if (insertVideoSetting.getYesInsertVideo() == true) {
					List<String> videos = insertVideoSetting.getVideos();
					for (int i = 0; i < videos.size(); i++) {
						if (insertVideoSetting.getAutoChooseVideoID()) {
							videoId = videos.get((int) (Math.random() * videos.size()));
						} else {
							videoId = videos.get(i);
						}

						if (insertVideoSetting.getAddPositionRandom()) {
							position = (long) (Math.random() * videoNumber);
						}

						// insert your video into PLL
						insertVideoIntoPlaylist(addingPlaylistResult.getId(), videoId, position);
					}

				}

			}

			return addingPlaylistResult;
		}

	}

	/**
	 * Authorize the user, create a playlist, and add an item to the playlist.
	 *
	 * @param args
	 *            command line args (not used).
	 */
	public PlayListInfoDTO addPlayList(PlayListInfoDTO playListInfo)
			throws GoogleJsonResponseException, IOException, Throwable {

		Properties properties = new Properties();
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTIES_FILENAME);
		properties.load(in);

		String playListName = playListInfo.getTitle();
		String privacyStatus = playListInfo.getPrivacy();
		String description = playListInfo.getDescription();

		// This OAuth 2.0 access scope allows for full read/write access to the
		// authenticated user's account.
		List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube");

		/// String authCode = playListInfo.getAuthCode();
		String channelId = playListInfo.getChanel();

		// get access token from DB
		GoogleCredential credential = getCredential(channelId);

		// This object is used to make YouTube Data API requests.
		youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, credential)
				.setApplicationName("youtubetool").build();

		PlayListInfoDTO playListInfoEntity = insertPlaylist(playListName, description, privacyStatus);

		return playListInfoEntity;

	}

	public ChannelInfo getChannelInfor(AuthDTO auth) throws TokenResponseException, IOException, Exception {
		ChannelInfo channelInfor = new ChannelInfo();

		String authCode = auth.getAuthCode();
		Token createdToken = createTokenByAuthentication(authCode);
		String accessToken = createdToken.getAccessToken();

		String url = "https://www.googleapis.com/youtube/v3/channels?part=id&mine=true&access_token=" + accessToken;
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(url);
		ChannelResponse response = restTemplate.getForObject(url, ChannelResponse.class);

		List<Channel> items = response.getItems();
		Channel channel = items.get(0);
		// set channelID
		channelInfor.setChannelId(channel.getId());
		// delete the old token by User
		Token tokenDb = tokenService.getTokenByChannelId(channel.getId());

		Token newToken = new Token();
		newToken.setAccessToken(accessToken);
		newToken.setRefreshToken(createdToken.getRefreshToken());
		newToken.setChannelId(channel.getId());
		
		PlaylistListResponse playlistListResponse = getPlaylistsListByChannelId(channel.getId(), new Long(10));

		if (playlistListResponse != null) {
			int playlistNumber = 0;
			if (playlistListResponse.getPageInfo() != null) {
				playlistNumber = playlistListResponse.getPageInfo().getTotalResults();
			}
			channelInfor.setPlaylistNumber(playlistNumber);

			try {
				channelInfor.setChannelTitle(playlistListResponse.getItems().get(0).getSnippet().getChannelTitle());
			} catch (Exception e) {
				channelInfor.setChannelTitle("");
			}
			channelInfor.setPlayList(convertPlaylistListResponsetoPlayList(playlistListResponse));
		}

		
		if (tokenDb != null) {
			// update the existed token with new access token and refresh token
			newToken.setId(tokenDb.getId());
			tokenService.updateToken(newToken);
		} else {
			// insert new Channel Id
			tokenService.addToken(newToken);
			// also all into channel basic infor table
			ChannelBasicInfo channelBasicInfo = new ChannelBasicInfo();
			channelBasicInfo.setChannelId(channel.getId());
			channelBasicInfo.setChannelName(channelInfor.getChannelTitle());
			
			if(!StringUtils.isEmpty(auth.getUserId())) {
				User user = userService.getUserByUserId(auth.getUserId());				
				channelBasicInfo.setUser(user);
			}
			channelBasicInfoService.addChannel(channelBasicInfo);
			
		}

		return channelInfor;
	}

	private Token createTokenByAuthentication(String authCode) throws TokenResponseException, IOException {
		Reader clientSecretReader = new InputStreamReader(Auth.class.getResourceAsStream("/client_secrets.json"));

		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(Auth.JSON_FACTORY, clientSecretReader);

		GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(Auth.HTTP_TRANSPORT,
				Auth.JSON_FACTORY, "https://www.googleapis.com/oauth2/v4/token",
				clientSecrets.getDetails().getClientId(), clientSecrets.getDetails().getClientSecret(), authCode,
				REDIRECT_URI).execute();
		String accessToken = tokenResponse.getAccessToken();
		String refreshToken = tokenResponse.getRefreshToken();

		Token newToken = new Token();
		newToken.setAccessToken(accessToken);
		newToken.setRefreshToken(refreshToken);

		return newToken;

	}

	private List<PlayList> convertPlaylistListResponsetoPlayList(PlaylistListResponse playlistListResponse) {
		List<com.google.api.services.youtube.model.Playlist> playlistItems = playlistListResponse.getItems();

		List<PlayList> playlists = new ArrayList<>();
		for (Playlist pll : playlistItems) {
			PlayList a = new PlayList();
			a.setId(pll.getId());
			a.setVideoNumber(pll.getContentDetails().getItemCount().intValue());
			com.google.api.services.youtube.model.PlaylistSnippet playlistSnippet = pll.getSnippet();

			if (playlistSnippet != null) {
				a.setTitle(playlistSnippet.getTitle());
				a.setDescription(playlistSnippet.getDescription());
				a.setPublishedAt(playlistSnippet.getPublishedAt());

			}
			playlists.add(a);

		}
		return playlists;
	}

	public PlaylistListResponse getPlaylistsListByChannelId(String channelId, Long maxResults)
			throws TokenResponseException, IOException, Exception {

		Properties properties = new Properties();

		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTIES_FILENAME);
		properties.load(in);

		String apiKey = properties.getProperty("youtube.apikey");

		// This object is used to make YouTube Data API requests.
		youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, new HttpRequestInitializer() {
			public void initialize(HttpRequest request) throws IOException {
			}
		}).setYouTubeRequestInitializer(new YouTubeRequestInitializer(apiKey)).setApplicationName("youtubetool")
				.build();

		HashMap<String, String> parameters = new HashMap<>();
		parameters.put("part", "snippet,contentDetails");
		parameters.put("channelId", channelId);
		parameters.put("maxResults", maxResults + "");

		YouTube.Playlists.List playlistsListByChannelIdRequest = youtube.playlists()
				.list(parameters.get("part").toString());
		if (parameters.containsKey("channelId") && parameters.get("channelId") != "") {
			playlistsListByChannelIdRequest.setChannelId(parameters.get("channelId").toString());
		}

		if (parameters.containsKey("maxResults")) {
			playlistsListByChannelIdRequest.setMaxResults(Long.parseLong(parameters.get("maxResults").toString()));
		}

		PlaylistListResponse playlistListResponse = playlistsListByChannelIdRequest.execute();

		return playlistListResponse;

	}

	public GoogleCredential getCredential(String channelId) throws IOException {
		Reader clientSecretReader = new InputStreamReader(Auth.class.getResourceAsStream("/client_secrets.json"));
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(Auth.JSON_FACTORY, clientSecretReader);

		GoogleCredential credential = new GoogleCredential();
		Token token = null;
		if (StringUtils.isNoneBlank(channelId)) {
			token = tokenService.getTokenByChannelId(channelId);
		}

		if (token == null) {
			System.out.println("Channel Id is not existed in Database");
			return null;

		} else {
			String accessToken = token.getAccessToken();
			// check access token is expired or not
			RestTemplate restTemplate = new RestTemplate();
			String URL_CHANNEL_LIST = "https://www.googleapis.com/oauth2/v1/tokeninfo?";
			URL_CHANNEL_LIST = URL_CHANNEL_LIST + "access_token=" + accessToken;
			try {
				AccessTokenInfo t = restTemplate.getForObject(URL_CHANNEL_LIST, AccessTokenInfo.class);
				credential.setAccessToken(accessToken);
			} catch (Exception e) {
				// token is invalid, we need to get new access token and update
				String URL_GET_NEW_ACCESS_TOKEN = "https://www.googleapis.com/oauth2/v4/token";
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

				MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
				map.add("client_id", clientSecrets.getDetails().getClientId());
				map.add("client_secret", clientSecrets.getDetails().getClientSecret());
				map.add("refresh_token", token.getRefreshToken());
				map.add("grant_type", "refresh_token");
				HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map,
						headers);
				ResponseEntity<RefreshToken> t = restTemplate.postForEntity(URL_GET_NEW_ACCESS_TOKEN, request,
						RefreshToken.class);

				RefreshToken newAccessToken = t.getBody();
				token.setAccessToken(newAccessToken.getAccess_token());
				// update new access token into DB
				tokenService.updateToken(token);
				credential.setAccessToken(newAccessToken.getAccess_token());
			}
		}

		return credential;
	}

	/**
	 * Create a playlist and add it to the authorized account.
	 */
	private static PlayListInfoDTO insertPlaylist(String title, String description, String privacyStatus)
			throws IOException {
		// String title, String description

		// This code constructs the playlist resource that is being inserted.
		// It defines the playlist's title, description, and privacy status.
		PlaylistSnippet playlistSnippet = new PlaylistSnippet();
		playlistSnippet.setTitle(title);
		playlistSnippet.setDescription(description);
		PlaylistStatus playlistStatus = new PlaylistStatus();
		if (StringUtils.isEmpty(privacyStatus)) {
			privacyStatus = "private";
		}
		playlistStatus.setPrivacyStatus(privacyStatus);

		Playlist youTubePlaylist = new Playlist();
		youTubePlaylist.setSnippet(playlistSnippet);
		youTubePlaylist.setStatus(playlistStatus);

		// Call the API to insert the new playlist. In the API call, the first
		// argument identifies the resource parts that the API response should
		// contain, and the second argument is the playlist being inserted.
		YouTube.Playlists.Insert playlistInsertCommand = youtube.playlists().insert("snippet,status", youTubePlaylist);
		Playlist playlistInfo = playlistInsertCommand.execute();

		return new PlayListInfoDTO(playlistInfo.getId(), playlistInfo.getSnippet().getTitle(),
				playlistInfo.getStatus().getPrivacyStatus(), playlistInfo.getSnippet().getDescription(),
				playlistInfo.getSnippet().getPublishedAt(), playlistInfo.getSnippet().getChannelId());

	}

	/**
	 * Create a playlist item with the specified video ID and add it to the
	 * specified playlist.
	 *
	 * @param playlistId
	 *            assign to newly created playlistitem
	 * @param videoId
	 *            YouTube video id to add to playlistitem
	 */
	public PlayListInfoDTO insertPlaylistItem(String playlistId, String videoId) throws IOException {

		// Define a resourceId that identifies the video being added to the
		// playlist.
		ResourceId resourceId = new ResourceId();
		resourceId.setKind("youtube#video");
		resourceId.setVideoId(videoId);

		// Set fields included in the playlistItem resource's "snippet" part.
		PlaylistItemSnippet playlistItemSnippet = new PlaylistItemSnippet();
		playlistItemSnippet.setTitle("First video in the test playlist");
		playlistItemSnippet.setPlaylistId(playlistId);
		playlistItemSnippet.setResourceId(resourceId);

		// Create the playlistItem resource and set its snippet to the
		// object created above.
		PlaylistItem playlistItem = new PlaylistItem();
		playlistItem.setSnippet(playlistItemSnippet);

		// Call the API to add the playlist item to the specified playlist.
		// In the API call, the first argument identifies the resource parts
		// that the API response should contain, and the second argument is
		// the playlist item being inserted.
		YouTube.PlaylistItems.Insert playlistItemsInsertCommand;

		playlistItemsInsertCommand = youtube.playlistItems().insert("snippet,contentDetails", playlistItem);
		PlaylistItem returnedPlaylistItem = playlistItemsInsertCommand.execute();
		PlayListInfoDTO playListInfoEntity = new PlayListInfoDTO(returnedPlaylistItem.getId(),
				returnedPlaylistItem.getSnippet().getTitle(), null, returnedPlaylistItem.getSnippet().getDescription(),
				returnedPlaylistItem.getSnippet().getPublishedAt(), returnedPlaylistItem.getSnippet().getChannelId());

		return playListInfoEntity;

	}

	/**
	 * insert into a specified playlist item with the specified video ID
	 * 
	 * @param playlistId
	 * @param videoId
	 *            YouTube video id to add to playlistitem
	 * @param position
	 * @return
	 */
	public PlayListInfoDTO insertVideoIntoPlaylist(String playlistId, String videoId, Long position)
			throws IOException {

		// Define a resourceId that identifies the video being added to the
		// playlist.
		HashMap<String, String> parameters = new HashMap<>();
		parameters.put("part", "snippet");

		PlaylistItem playlistItem = new PlaylistItem();
		PlaylistItemSnippet snippet = new PlaylistItemSnippet();
		snippet.set("playlistId", playlistId);
		snippet.set("position", position);
		ResourceId resourceId = new ResourceId();
		resourceId.set("kind", "youtube#video");
		resourceId.set("videoId", videoId);

		snippet.setResourceId(resourceId);
		playlistItem.setSnippet(snippet);

		YouTube.PlaylistItems.Insert playlistItemsInsertRequest = youtube.playlistItems()
				.insert(parameters.get("part").toString(), playlistItem);

		PlaylistItem returnedPlaylistItem = playlistItemsInsertRequest.execute();
		PlayListInfoDTO playListInfoEntity = new PlayListInfoDTO(returnedPlaylistItem.getId(),
				returnedPlaylistItem.getSnippet().getTitle(), null, returnedPlaylistItem.getSnippet().getDescription(),
				returnedPlaylistItem.getSnippet().getPublishedAt(), returnedPlaylistItem.getSnippet().getChannelId());

		return playListInfoEntity;

	}

}
