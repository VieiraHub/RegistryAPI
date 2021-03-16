package com.vieiratelier.access.infra.adapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.vieiratelier.access.boundary.port.PasswordEncoder;

@Component
public class PasswordEncoderImpl implements PasswordEncoder {

	
	private final BCryptPasswordEncoder encoder;
	
	public PasswordEncoderImpl(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}

	@Override
	public String execute(String password) {
		return encoder.encode(password);
	}

}
