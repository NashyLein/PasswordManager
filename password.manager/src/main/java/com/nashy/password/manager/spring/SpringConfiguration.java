package com.nashy.password.manager.spring;

import javax.swing.JFrame;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nashy.password.manager.swing.AccountCreationDialog;
import com.nashy.password.manager.swing.LoginDialog;

@Configuration
public class SpringConfiguration {
	
	@Bean
	public LoginDialog loginDialog(JFrame parent) {
		return new LoginDialog(parent);
	}
	
	@Bean
	public AccountCreationDialog accountCreationDialog(JFrame parent) {
		return new AccountCreationDialog(parent);
	}
	
}
