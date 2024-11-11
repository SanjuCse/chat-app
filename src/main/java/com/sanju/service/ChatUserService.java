package com.sanju.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sanju.common.Status;
import com.sanju.model.ChatUser;
import com.sanju.repo.ChatUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatUserService {

	private final ChatUserRepository repository;

	public void saveUser(ChatUser user) {
		user.setStatus(Status.ONLINE);
		repository.save(user);
	}

	public void disconnect(ChatUser user) {
		var storedUser = repository.findById(user.getNickName()).orElse(null);
		if (storedUser != null) {
			storedUser.setStatus(Status.OFFLINE);
			repository.save(storedUser);
		}
	}

	public List<ChatUser> findConnectedUsers() {
		return repository.findAllByStatus(Status.ONLINE);
	}
}
