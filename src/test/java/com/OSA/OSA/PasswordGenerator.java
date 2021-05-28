package com.OSA.OSA;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "ivan";
		String encodedPass = encoder.encode(rawPassword);
		
		System.out.println(encodedPass);

	}

}
