package com.vieiratelier.access.infra.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vieiratelier.access.application.configuration.SpringApplicationContext;
import com.vieiratelier.access.infra.controller.user.UserControllerImpl;
import com.vieiratelier.access.infra.presenter.user.request.UserLoginRequest;
import com.vieiratelier.access.infra.presenter.user.response.UserResponse;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;
	
	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, 
			HttpServletResponse response) throws AuthenticationException {
	
		try {
			UserLoginRequest userRequest = new ObjectMapper()
					.readValue(request.getInputStream(), UserLoginRequest.class);
			
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							userRequest.email, userRequest.password, new ArrayList<>()));
		} catch (IOException e) {  throw new RuntimeException(e);  }
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			FilterChain chain, Authentication auth) throws IOException, ServletException {
	
		String userName = ((User) auth.getPrincipal()).getUsername();
		String token = Jwts.builder()
			.setSubject(userName)
			.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
			.signWith(SignatureAlgorithm.HS512, "alf1319asfas11")
			.compact();
		UserControllerImpl userController = (UserControllerImpl) SpringApplicationContext.getBean("userControllerImpl");
		UserResponse userResponse = userController.findUserByEmail(userName);
		response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
		response.addHeader("UserID", userResponse.userId);
	}
}

