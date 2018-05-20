package com.fasty2b.youtube.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasty2b.youtube.dto.ChannelBasicDTO;
import com.fasty2b.youtube.dto.ResponseDTO;
import com.fasty2b.youtube.service.IChannelService;
import com.fasty2b.youtube.utils.Constants;

@CrossOrigin
@RestController
public class ChannelController {
	
	
	@Autowired
	private IChannelService channelService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/getAllChannelByUserId")
	public ResponseDTO<List<ChannelBasicDTO>> getChannelByUserId(@RequestParam("userId") String userId)
			throws InterruptedException {
		ResponseDTO<List<ChannelBasicDTO>> responseEntity = new ResponseDTO<List<ChannelBasicDTO>>(
				Constants.ERROR_CODE, "", null);		
		try {
			List<ChannelBasicDTO> channels = channelService.getChannelByUserId(userId);
			responseEntity.setData(channels);
			responseEntity.setCode(Constants.SUCCESS_CODE);

		} catch (Throwable t) {
			responseEntity.setCode(Constants.ERROR_CODE);
			responseEntity.setMessage(t.getMessage());
			System.out.println(t.getMessage());
		}
		return responseEntity;

	}


}
