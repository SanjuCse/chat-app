package com.sanju.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sanju.common.Status;
import com.sanju.model.ChatUser;

public interface ChatUserRepository extends MongoRepository<ChatUser, String> {
	List<ChatUser> findAllByStatus(Status status);
}
