package com.fasty2b.youtube.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.google.api.client.auth.oauth2.TokenResponseException;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.fasty2b.youtube.dto.AuthDTO;
import com.fasty2b.youtube.dto.ChannelInfo;
import com.fasty2b.youtube.dto.ResponseDTO;
import com.fasty2b.youtube.dto.UserInfo;
import com.fasty2b.youtube.entity.User;
import com.fasty2b.youtube.service.IUserService;
import com.fasty2b.youtube.service.PlaylistService;
import com.fasty2b.youtube.utils.Constants;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private PlaylistService playlistService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/getUsers")
	public ResponseDTO<List<User>> getAllUsers() {
		
		List<User> users = userService.getAllUsers();
		
		return new ResponseDTO<List<User>>(0, Constants.SUCCESS, users );
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ResponseDTO<UserInfo> login(@RequestBody UserInfo user) {
		ResponseDTO<UserInfo> response = new ResponseDTO<UserInfo>(Constants.ERROR_CODE,
				"");
		User userNeedToCheck = new User();
		userNeedToCheck.setUserId(user.getUserId());
		userNeedToCheck.setUserPass(user.getPassword());		
		boolean checkResult = userService.checkUser(userNeedToCheck);
		
		if (checkResult) {
			response.setCode(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS);
		} else {
			response.setCode(Constants.ERROR_CODE);
			response.setMessage(Constants.LOGIN_FAIL_MESSAGE);
		}
		return response;

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/getUserInfor")
	public ResponseDTO<ChannelInfo> getUserInfo(@RequestBody AuthDTO auth) {
		ResponseDTO<ChannelInfo> response = new ResponseDTO<ChannelInfo>(Constants.ERROR_CODE,
				"");	
		try {
			ChannelInfo channelInfo = playlistService.getChannelInfor(auth);
			response.setCode(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS);
			response.setData(channelInfo);
		} catch (TokenResponseException e) {
			response.setCode(e.getStatusCode());
			response.setMessage(e.getMessage());
			System.out.println("ERROR TokenResponseException: " + e.getMessage());
		} catch (GoogleJsonResponseException e ) {			
			response.setCode(e.getStatusCode());
			response.setMessage(e.getMessage());
			System.out.println("ERROR GoogleJsonResponseException: " + e.getMessage());
		}
		catch (IOException e ) {			
			response.setCode(Constants.ERROR_CODE);
			response.setMessage(e.getMessage());
			System.out.println("ERROR IOException: " + e.getMessage());
		} catch (HttpClientErrorException e) {
			response.setCode(e.getRawStatusCode());
			response.setMessage(e.getMessage());
			System.out.println("ERROR HttpClientErrorException: " + e.getRootCause());
		} catch (Exception e) {
			response.setCode(Constants.ERROR_CODE);
			response.setMessage(e.getMessage() + e.getCause());
			System.out.println("ERROR Exception: " + e.getMessage());
		}
		return response;

	}
	
	
	
}
