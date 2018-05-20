package com.fasty2b.youtube.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasty2b.youtube.dao.ChannelBasicInfoRepository;
import com.fasty2b.youtube.dao.UserRepository;
import com.fasty2b.youtube.dto.ChannelBasicDTO;
import com.fasty2b.youtube.entity.ChannelBasicInfo;

@Service
public class ChannelService implements IChannelService {

	@Autowired
	private ChannelBasicInfoRepository channelBasicInfoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<ChannelBasicDTO> getChannelByUserId(String userId) {
		List<ChannelBasicInfo> channels = channelBasicInfoRepository.findByUser(userRepository.findByUserId(userId));
		// convert from channel entities to channel DTOs
		
		List<ChannelBasicDTO> resultChannels = new ArrayList<>();
		for(ChannelBasicInfo e: channels) {
			ChannelBasicDTO dto = new ChannelBasicDTO();
			dto.setChannelId(e.getChannelId());
			dto.setChannelTitle(e.getChannelName());
			resultChannels.add(dto);
		}
		
		return resultChannels;		
	}

}
