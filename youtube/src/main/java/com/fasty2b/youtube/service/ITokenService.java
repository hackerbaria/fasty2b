package com.fasty2b.youtube.service;

import java.util.List;

import com.fasty2b.youtube.entity.Token;

public interface ITokenService {
     List<Token> getAllTokens();
     Token getTokenByUserId(String userId);
     boolean addToken(Token token);
     void updateToken(Token token);
     void deleteToken(String userId);
     
     Token findByAccessToken(String accessToken);
     boolean updateTokenByAccessToken(String accessToken, String channelId);
     
     boolean updateTokenByUserId(Token token);
}
