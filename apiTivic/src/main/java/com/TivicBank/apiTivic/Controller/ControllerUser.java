package com.TivicBank.apiTivic.Controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.TivicBank.apiTivic.Objects.User;
import com.TivicBank.apiTivic.Service.FirebaseService;


@RestController
public class ControllerUser {
	
	@Autowired
	FirebaseService fireBaseService;

	@GetMapping("/getUserDetails")
	public User getUser(@RequestHeader() String name) throws InterruptedException, ExecutionException {
		return fireBaseService.getUserDetails(name);
	}
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() throws InterruptedException, ExecutionException {
		return fireBaseService.getAllUsers();
	}
	@PostMapping("/createUser")
	public String postUser(@RequestBody User user) throws InterruptedException, ExecutionException {
	return fireBaseService.saveUserDetails(user);
	}
	@PutMapping("/updateUser")
	public String putUser(@RequestBody User user) throws InterruptedException, ExecutionException {
		return fireBaseService.updateUserDetails(user);
	}
	@DeleteMapping("/deleteUser/{name}")
	public String deleteUser(@PathVariable String name) throws InterruptedException, ExecutionException {
		return fireBaseService.deleteUserDetails(name);
	}
}
