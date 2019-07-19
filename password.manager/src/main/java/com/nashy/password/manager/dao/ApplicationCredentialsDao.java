package com.nashy.password.manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nashy.password.manager.core.ApplicationCredentials;

public interface ApplicationCredentialsDao
		extends JpaRepository<ApplicationCredentials, String> {

}
