package com.vieiratelier.access.infra.security;

import com.vieiratelier.access.application.configuration.SpringApplicationContext;

public class SecurityConstants {
	public static final long EXPIRATION_TIME = 18000000; // 18000000 5h, 86400000 24h, 172800000 48h  
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/users";
//	public static final String TOKEN_SECRET = "alf1319asfas11";
	
	public static String getSecretToken() {
		AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("appProperties");
		return appProperties.getSecretToken();
	}
}
