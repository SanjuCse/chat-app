package com.sanju.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sanju.model.ChatRoom;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {
    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
