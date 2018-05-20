package com.fasty2b.youtube.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fasty2b.youtube.entity.ChannelBasicInfo;
import com.fasty2b.youtube.entity.User;

public interface ChannelBasicInfoRepository extends CrudRepository<ChannelBasicInfo, Integer> {
	
	ChannelBasicInfo findByChannelId(String channelId);	
	List<ChannelBasicInfo> findByUser(User user);

}
