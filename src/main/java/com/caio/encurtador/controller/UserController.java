package com.caio.encurtador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caio.encurtador.model.User;
import com.caio.encurtador.service.UserService;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody User user) {
		return userService.create(user);
	}
	
	@GetMapping
	public List<User> getAll() {
		return userService.getAll();
	}
	
}
