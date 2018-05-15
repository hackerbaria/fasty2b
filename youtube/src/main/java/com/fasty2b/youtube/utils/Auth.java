package com.fasty2b.youtube.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.fasty2b.youtube.entity.Token;
import com.fasty2b.youtube.service.ITokenService;

/**
 * Shared class used by every sample. Contains methods for authorizing a user
 * and caching credentials.
 */
public class Auth {

	/* Auth */
	/**
	 * Define a global instance of the HTTP transport.
	 */
	public static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

	/*
	 * private static final String REDIRECT_URI =
	 * "http://test.tokybook.com:8081/autoplaylist/callback";
	 */

	private static final String REDIRECT_URI = "http://localhost:8080/callback";

	/**
	 * Define a global instance of the JSON factory.
	 */
	public static final JsonFactory JSON_FACTORY = new JacksonFactory();

	@Autowired
	static
	private ITokenService tokenService;

	public static GoogleCredential authorize(List<String> scopes, String authCode, String channelID) throws IOException {
		GoogleCredential credential = new GoogleCredential();

		String channel = channelID;
		Token token = tokenService.getTokenByUserId(channel);

		Reader clientSecretReader = new InputStreamReader(Auth.class.getResourceAsStream("/client_secrets.json"));
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(Auth.JSON_FACTORY, clientSecretReader);

		if (token == null) {
			GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(Auth.HTTP_TRANSPORT,
					Auth.JSON_FACTORY, "https://www.googleapis.com/oauth2/v4/token",
					clientSecrets.getDetails().getClientId(), clientSecrets.getDetails().getClientSecret(), authCode,
					REDIRECT_URI).execute();
			String accessToken = tokenResponse.getAccessToken();
			String refreshToken = tokenResponse.getRefreshToken();

			Token newToken = new Token();
			newToken.setUserId(channel);
			newToken.setAccessToken(accessToken);
			newToken.setRefreshToken(refreshToken);
			tokenService.addToken(newToken);
			// Use access token to call API
			credential = new GoogleCredential().setAccessToken(accessToken);

		} else {
			String accessToken = token.getAccessToken();
			credential.setAccessToken(accessToken);
		}

		return credential;

	}

}
