package com.fasty2b.youtube.service;

import java.util.List;

import com.fasty2b.youtube.entity.ChannelBasicInfo;

public interface IChannelBasicInfoService {
	
	List<ChannelBasicInfo> getAllChannel();
	ChannelBasicInfo getChannelByChannelId(String channelId);
    boolean addChannel(ChannelBasicInfo channel);
    void updateChannel(ChannelBasicInfo channel);
    void deleteChannel(String channelId);
    
   

}
