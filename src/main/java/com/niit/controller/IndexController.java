package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.model.User;
import com.niit.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class IndexController
{
	@Autowired
	UserRepository userRepository;

	@GetMapping(value = {"/home"})
	public String m1()
	{
		return "index";
	}
	
	@GetMapping(value = {"/"})
	public ResponseEntity<List<User>> getUsers()
	{
		return new ResponseEntity<List<User>>(userRepository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value = {"/id/{userid}"})
	public ResponseEntity<User> getUserById(@PathVariable("userid") int userid)
	{
		return new ResponseEntity<User>(userRepository.findByUserid(userid),HttpStatus.OK);
	}
	
	@GetMapping(value = {"/email/{email}"})
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email)
	{
		return new ResponseEntity<User>(userRepository.findByEmail(email),HttpStatus.OK);
	}
	
	@GetMapping(value = {"/username/{username}"})
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username)
	{
		return new ResponseEntity<User>(userRepository.findByUsername(username),HttpStatus.OK);
	}
	
	@PostMapping(value = {"/add"})
	public ResponseEntity<Void> adduser(@RequestBody User user)
	{
		userRepository.save(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = {"/delete/{userid}"})
	public ResponseEntity<Void> deleteuser(@PathVariable("userid") int userid)
	{
		User user=new User();
		user.setUserid(userid);
		
		userRepository.delete(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping(value = {"/update"})
	public ResponseEntity<Void> updateUser(@RequestBody User user)
	{
		userRepository.save(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
		
}
