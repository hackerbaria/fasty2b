package com.fasty2b.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.youtube.model.PlaylistListResponse;
import com.fasty2b.youtube.dto.DescriptionSetting;
import com.fasty2b.youtube.dto.GeneralSetting;
import com.fasty2b.youtube.dto.InsertVideoSetting;
import com.fasty2b.youtube.dto.MultiPlayListInfoDTO;
import com.fasty2b.youtube.dto.PlayListInfoDTO;
import com.fasty2b.youtube.dto.ResponseDTO;
import com.fasty2b.youtube.dto.SearchVideoSetting;
import com.fasty2b.youtube.dto.SinglePlayListInfoDTO;
import com.fasty2b.youtube.dto.TitleSetting;
import com.fasty2b.youtube.service.PlaylistService;
import com.fasty2b.youtube.utils.Constants;

@CrossOrigin
@RestController
public class PlaylistController {

	private static final Logger logger = LogManager.getLogger(PlaylistController.class);

	@Autowired
	private PlaylistService playlistService;

	@RequestMapping("*/")
	public String welcome() {
		return "Welcome to Spring Boot Tutorials";
	}

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return name;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addSinglePlaylist")
	public ResponseDTO<PlayListInfoDTO> addSinglePlaylist(@RequestBody SinglePlayListInfoDTO playlistInfo) {
		ResponseDTO<PlayListInfoDTO> responseEntity = new ResponseDTO<PlayListInfoDTO>(Constants.ERROR_CODE,
				"", null);
		System.out.println("start addMultiPlaylist");
		System.out.println("input from UI: " + playlistInfo);

		String keyword = playlistInfo.getName();
		PlayListInfoDTO playListInfoEntity = new PlayListInfoDTO();
		playListInfoEntity.setChanel(playlistInfo.getChanel());
		SearchVideoSetting searchVideoSetting = playlistInfo.getSearchVideoSetting();
		TitleSetting titleSetting = playlistInfo.getTitleSetting();
		DescriptionSetting descriptionSetting = playlistInfo.getDescriptionSetting();
		GeneralSetting generalSetting = playlistInfo.getGeneralSetting();
		InsertVideoSetting insertVideoSetting = playlistInfo.getInsertVideoSetting();

		// trim and capitalize the first character of each word in a string
		keyword = StringUtils.trim(keyword);
		keyword = WordUtils.capitalize(keyword);
		playListInfoEntity.setTitle(keyword);
		try {
			PlayListInfoDTO pll = playlistService.createPlayListAndAddVideos(playListInfoEntity,
					searchVideoSetting, titleSetting, descriptionSetting, generalSetting, insertVideoSetting);

			responseEntity.setCode(Constants.SUCCESS_CODE);
			responseEntity.setMessage(Constants.SUCCESS);
			responseEntity.setData(pll);
			System.out.println("end addSinglePlaylist - ok ok ok");
		} catch (GoogleJsonResponseException e) {
			responseEntity.setCode(e.getStatusCode());
			responseEntity.setMessage(e.getMessage());
		} catch (IOException e) {
			responseEntity.setCode(Constants.ERROR_CODE);
			responseEntity.setMessage(e.getMessage());
		} catch (Throwable t) {
			responseEntity.setCode(Constants.ERROR_CODE);
			responseEntity.setMessage(t.getMessage());
		}

		return responseEntity;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/addMultiPlaylist")
	public ResponseDTO<List<PlayListInfoDTO>> addMultiPlaylist(@RequestBody MultiPlayListInfoDTO playlistInfo)
			throws InterruptedException {
		ResponseDTO<List<PlayListInfoDTO>> responseEntity = new ResponseDTO<List<PlayListInfoDTO>>(
				Constants.ERROR_CODE, "", null);
		System.out.println("start addMultiPlaylist");
		System.out.println("input from UI: " + playlistInfo);

		List<String> keywords = playlistInfo.getNames();
		PlayListInfoDTO playListInfoEntity = new PlayListInfoDTO();
		playListInfoEntity.setChanel(playlistInfo.getChanel());
		SearchVideoSetting searchVideoSetting = playlistInfo.getSearchVideoSetting();
		/*if (searchVideoSetting.getMaxResults() > 25) {
			searchVideoSetting.setMaxResults(25);
		}
		searchVideoSetting.setMinResults(0);*/
		TitleSetting titleSetting = playlistInfo.getTitleSetting();
		DescriptionSetting descriptionSetting = playlistInfo.getDescriptionSetting();
		GeneralSetting generalSetting = playlistInfo.getGeneralSetting();
		InsertVideoSetting insertVideoSetting = playlistInfo.getInsertVideoSetting();

		List<PlayListInfoDTO> playLists = new ArrayList<>();

		try {
			for (String keyword : keywords) {
				// trim and capitalize the first character of each word in a string
				keyword = StringUtils.trim(keyword);
				keyword = WordUtils.capitalize(keyword);
				playListInfoEntity.setTitle(keyword);
				PlayListInfoDTO pll = playlistService.createPlayListAndAddVideos(playListInfoEntity,
						searchVideoSetting, titleSetting, descriptionSetting, generalSetting, insertVideoSetting);
				playLists.add(pll);
				System.out.println("finished creating pll " + keyword);
				// delay 30s
				//TimeUnit.SECONDS.sleep(30);
			}

			responseEntity.setCode(Constants.SUCCESS_CODE);
			responseEntity.setMessage(Constants.SUCCESS);
			responseEntity.setData(playLists);
			System.out.println("end addMultiPlaylist");

		} catch (GoogleJsonResponseException e) {
			responseEntity.setCode(e.getStatusCode());
			responseEntity.setMessage(e.getMessage());
			System.out.println(e.getMessage());
		} catch (IOException e) {
			responseEntity.setCode(Constants.ERROR_CODE);
			responseEntity.setMessage(e.getMessage());
			System.out.println(e.getMessage());
		} catch (Throwable t) {
			responseEntity.setCode(Constants.ERROR_CODE);
			responseEntity.setMessage(t.getMessage());
			System.out.println(t.getMessage());
		}
		return responseEntity;

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getPlaylistsListByChannelId")
	public ResponseDTO<PlaylistListResponse> getPlaylistsListByChannelId(@RequestParam("channelId") String channelId, 
			@RequestParam("maxResults") Long maxResults)
			throws InterruptedException {
		ResponseDTO<PlaylistListResponse> responseEntity = new ResponseDTO<PlaylistListResponse>(
				Constants.ERROR_CODE, "", null);		
		try {
			PlaylistListResponse playlists = new PlaylistListResponse();
			playlists = playlistService.getPlaylistsListByChannelId(channelId, maxResults);
			responseEntity.setCode(Constants.SUCCESS_CODE);
			responseEntity.setData(playlists);

		} catch (GoogleJsonResponseException e) {
			responseEntity.setCode(e.getStatusCode());
			responseEntity.setMessage(e.getMessage());
			System.out.println(e.getMessage());
		} catch (IOException e) {
			responseEntity.setCode(Constants.ERROR_CODE);
			responseEntity.setMessage(e.getMessage());
			System.out.println(e.getMessage());
		} catch (Throwable t) {
			responseEntity.setCode(Constants.ERROR_CODE);
			responseEntity.setMessage(t.getMessage());
			System.out.println(t.getMessage());
		}
		return responseEntity;

	}
	

}