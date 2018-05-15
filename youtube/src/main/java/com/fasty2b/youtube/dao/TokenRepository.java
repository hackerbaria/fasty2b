package com.fasty2b.youtube.dao;

import org.springframework.data.repository.CrudRepository;

import com.fasty2b.youtube.entity.Token;



public interface TokenRepository extends CrudRepository<Token, Long>  {
	Token findByUserId(String userId);	
	Token findByAccessToken(String accessToken);
    
}
