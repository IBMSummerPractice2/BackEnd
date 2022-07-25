package com.ibm.ro.tm.apprenticeship.poll.metter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.UserRepository;


@RestController
public class UserController {

	private final UserRepository repository;

	public UserController(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/users")
	public List<User> all() {
		return repository.findAll();
	}

	@PostMapping("/add-user")
	User addUser(
			@RequestBody User user
	) {
		return repository.save(user);
	}

//	@PostMapping("/add-user/{name}/{role}")
//	User addUser(
//			@PathVariable String name,
//			@PathVariable Role role
//	){
//		User user = new User(name,role);
//		return repository.save(user);
//	}
}
