package com.nashy.password.manager;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashy.password.manager.core.ApplicationCredentials;
import com.nashy.password.manager.core.User;
import com.nashy.password.manager.dao.UserDao;

@Service
public class Services {
	
	@Autowired
	private UserDao userDao;

	public boolean authenticate(String userName, String password) {
		Optional<User> opt = userDao.findById(userName);
		return opt.filter(us -> us.getPassword().equals(password)).isPresent();
	}

	public void populateDB() {
		User test = new User("admin", "admin");
    	test.getApplications().add(new ApplicationCredentials("test", "admin", "pass"));
        userDao.save(test);
		
	}

	public boolean createUser(String username, String password) {
		User user = new User(username, password);
		userDao.save(user);
		return true;
	}

	public boolean accountAlreadyExist(String username) {
		return userDao.findById(username).isPresent();
	}

}
