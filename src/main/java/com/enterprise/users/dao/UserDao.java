package com.enterprise.users.dao;

import java.util.List;

import com.enterprise.users.model.User;

public interface UserDao {

	public User getUser(String firstName);

	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

	public List<User> getAllUsers();

}
