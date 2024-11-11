package com.sanju.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanju.model.ChatUser;
import com.sanju.service.ChatUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final ChatUserService userService;

	@MessageMapping("/user.addUser")
	@SendTo("/user/topic/public")
	public ChatUser addUser(@Payload ChatUser user) {
		userService.saveUser(user);
		return user;
	}

	@MessageMapping("/user.disconnectUser")
	@SendTo("/user/topic/public")
	public ChatUser disconnectUser(@Payload ChatUser user) {
		userService.disconnect(user);
		return user;
	}

	@GetMapping("/users")
	public ResponseEntity<List<ChatUser>> findConnectedUsers() {
		return ResponseEntity.ok(userService.findConnectedUsers());
	}
}
