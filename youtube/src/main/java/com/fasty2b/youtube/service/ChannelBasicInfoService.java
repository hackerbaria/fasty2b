package com.fasty2b.youtube.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasty2b.youtube.dao.ChannelBasicInfoRepository;
import com.fasty2b.youtube.entity.ChannelBasicInfo;

@Service
public class ChannelBasicInfoService implements IChannelBasicInfoService {

	@Autowired
	private ChannelBasicInfoRepository channelBasicInfoRepository;

	@Override
	public List<ChannelBasicInfo> getAllChannel() {
		List<ChannelBasicInfo> list = new ArrayList<>();
		channelBasicInfoRepository.findAll().forEach(e -> list.add(e));
		return list;		
	}

	@Override
	public ChannelBasicInfo getChannelByChannelId(String channelId) {		
		return channelBasicInfoRepository.findByChannelId(channelId);
	}

	@Override
	public boolean addChannel(ChannelBasicInfo channel) {		
		channelBasicInfoRepository.save(channel);
		return true;
	}

	@Override
	public void updateChannel(ChannelBasicInfo channel) {
		channelBasicInfoRepository.save(channel);
		
	}

	@Override
	public void deleteChannel(String channelId) {
		channelBasicInfoRepository.delete(getChannelByChannelId(channelId));
		
	}
	
	
	

}
