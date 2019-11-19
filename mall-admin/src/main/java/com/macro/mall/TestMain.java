package com.macro.mall;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String result = encoder.encode("c76b6330feac162cb18f772b5273c156");
		System.out.println(result);
		if(encoder.matches("123456", "$2a$10$ys1pLxqjRRaoK.TCoVkTK.1Rv2Wus2rilsuryNkh91nUXOhtq4eui")) {
			System.out.println("matche");
		}else {
			System.out.println("not matche");
		}
	}

}
