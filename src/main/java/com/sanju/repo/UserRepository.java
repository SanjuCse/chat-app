package com.sanju.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sanju.common.Status;
import com.sanju.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	List<User> findAllByStatus(Status status);
}
