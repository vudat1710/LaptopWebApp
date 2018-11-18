package com.group14.project.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group14.project.web.beans.User;
import com.group14.project.web.dao.UserDao;

@Service("userService")
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public void addUser(User user) {
		userDao.saveUser(user);
	}
	
	public boolean isUsernameExisted(String username) {
		return userDao.isUsernameExisted(username);
	}
	
	public List<User> searchUsersByUserIdUsernameName(String userId, String username, String name){
		return userDao.searchUserByUserIdUsernameName(userId, username, name);
	}
	
	public User getUserByUserId(int userId) {
		return userDao.getUserByUserId(userId);
	}
	
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
}
