package com.caio.encurtador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.caio.encurtador.model.User;
import com.caio.encurtador.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public ResponseEntity<String> create(User user) {
		userRepository.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso!");
	}
	
	public List<User> getAll() {
		return userRepository.findAll();
	}
}
