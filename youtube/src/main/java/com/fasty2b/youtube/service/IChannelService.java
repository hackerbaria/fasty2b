package com.fasty2b.youtube.service;

import java.util.List;

import com.fasty2b.youtube.dto.ChannelBasicDTO;
import com.fasty2b.youtube.entity.ChannelBasicInfo;

public interface IChannelService {
	
	List<ChannelBasicDTO> getChannelByUserId(String userId);

}
