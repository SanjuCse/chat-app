package com.sanju.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sanju.model.ChatMessage;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    List<ChatMessage> findByChatId(String chatId);
}
