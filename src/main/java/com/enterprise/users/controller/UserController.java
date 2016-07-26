package com.enterprise.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.users.model.User;
import com.enterprise.users.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/{firstName}", method = RequestMethod.GET,  produces="application/json")
	public  @ResponseBody User getUser(@PathVariable("firstName") String firstName) {
		return userService.getUser(firstName);
	}
	
	@RequestMapping( method = RequestMethod.POST)
	@ResponseBody public String  insertUser(@RequestBody  User user) {
		System.out.println("controler " + user.getFirstName() + " " + user.getLastName() +  " " + user.getAge());
		userService.insertUser(user);
		return user.getFirstName();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteUser(@RequestBody  User user) {
		userService.deleteUser(user);
	}
	
	@RequestMapping(method = RequestMethod.GET,  produces="application/json")
	public  ResponseEntity<List<User>>  getUsers() {
		List<User> users = userService.getAllUsers();
		for(User user : users) {
			System.out.println(user.getFirstName() + " " + user.getLastName() );
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);

	}

}