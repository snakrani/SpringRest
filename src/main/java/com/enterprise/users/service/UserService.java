package com.enterprise.users.service;

import java.util.List;

import com.enterprise.users.model.User;

public interface UserService {

	public User getUser(String firstName);

	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

	public List<User> getAllUsers();

}
