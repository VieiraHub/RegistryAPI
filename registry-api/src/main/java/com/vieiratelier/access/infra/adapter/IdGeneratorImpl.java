package com.vieiratelier.access.infra.adapter;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.vieiratelier.access.boundary.port.IdGenerator;

@Component
public class IdGeneratorImpl implements IdGenerator {

	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	@Override
	public String execute() {
		return generateRandomString(30);
	}

	private String generateRandomString(int length) {
		StringBuilder returnValue = new StringBuilder(length);
		for(int i = 0; i < length; i++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		returnValue.append(new Date().getTime());
		return new String(returnValue);
	}
}
