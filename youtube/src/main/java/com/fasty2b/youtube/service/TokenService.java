package com.fasty2b.youtube.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasty2b.youtube.dao.TokenRepository;
import com.fasty2b.youtube.entity.Token;
@Service
public class TokenService implements ITokenService {
	@Autowired
	private TokenRepository tokenRepository;

	@Override
	public List<Token> getAllTokens() {
		List<Token> list = new ArrayList<>();
		tokenRepository.findAll().forEach(e -> list.add(e));
		return list;		
	}

	@Override
	public Token getTokenByChannelId(String channelId) {		
		return tokenRepository.findByChannelId(channelId);		
	}

	@Override
	public boolean addToken(Token token) {
		tokenRepository.save(token);
		return true;
	}

	@Override
	public void updateToken(Token token) {
		tokenRepository.save(token);
		
	}

	@Override
	public void deleteToken(String channelId) {
		tokenRepository.delete(getTokenByChannelId(channelId));
		
	}

	@Override
	public Token findByAccessToken(String accessToken) {
		return tokenRepository.findByAccessToken(accessToken);
	}

	@Override
	public boolean updateTokenByAccessToken(String accessToken, String channelId) {
		Token token = findByAccessToken(accessToken);
		token.setChannelId(channelId);
		tokenRepository.save(token);
		return true;
	}

	@Override
	public boolean updateTokenByUserId(Token token) {
		Token tokenDb = getTokenByChannelId(token.getChannelId());
		tokenDb.setAccessToken(token.getAccessToken());
		tokenDb.setRefreshToken(token.getRefreshToken());
		tokenRepository.save(tokenDb);
		
		return true;
	}
	
	
	
}
