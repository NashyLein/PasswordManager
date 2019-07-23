package com.nashy.password.manager.spring;

import javax.swing.JFrame;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.nashy.password.manager.swing.AccountCreationDialog;
import com.nashy.password.manager.swing.HomeDialog;
import com.nashy.password.manager.swing.LoginDialog;

@Configuration
public class SpringConfiguration {
	
	@Bean
	@Scope("prototype")
	public LoginDialog loginDialog(JFrame parent) {
		return new LoginDialog(parent);
	}
	
	@Bean
	@Scope("prototype")
	public AccountCreationDialog accountCreationDialog(JFrame parent) {
		return new AccountCreationDialog(parent);
	}
	
	@Bean
	@Scope("prototype")
	public HomeDialog homeDialog(JFrame parent, String login) {
		return new HomeDialog(parent, login);
	}
	
}
