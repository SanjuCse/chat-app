package com.sanju.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sanju.model.User;
import com.sanju.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@MessageMapping("/user.addUser")
	@SendTo("/user/topic/public")
	public User addUser(@Payload User user) {
		userService.saveUser(user);
		return user;
	}

	@MessageMapping("/user.disconnectUser")
	@SendTo("/user/topic/public")
	public User disconnectUser(@Payload User user) {
		userService.disconnect(user);
		return user;
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> findConnectedUsers() {
		return ResponseEntity.ok(userService.findConnectedUsers());
	}
}
