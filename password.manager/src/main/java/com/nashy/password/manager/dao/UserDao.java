package com.nashy.password.manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nashy.password.manager.core.User;

public interface UserDao extends JpaRepository<User, String> {

}
