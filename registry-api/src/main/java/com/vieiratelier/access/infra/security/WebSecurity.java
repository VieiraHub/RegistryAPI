package com.vieiratelier.access.infra.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vieiratelier.access.infra.controller.user.UserController;


@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	
	private final UserController controller;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurity(UserController controller, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.controller = controller;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(controller).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
		.anyRequest().authenticated()
		.and().addFilter(new AuthenticationFilter(authenticationManager()))
		.addFilter(new AuthorizationFilter(authenticationManager()))
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
//	Aqui é se quiser alterar o endpoint do login em vez de localhost:8080/login fica /users/login
//	e alterar no configure no addfilter authenticationFilter( aqui para getAuthenticationFilter )
//	public AuthenticationFilter getAuthenticationFilter() throws Exception {
//		final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
//		filter.setFilterProcessesUrl("/users/login");
//		return filter;
//	}
}

