package com.sanju.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sanju.model.ChatMessage;
import com.sanju.response.ChatNotification;
import com.sanju.service.ChatMessageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ChatController {

	private final SimpMessagingTemplate messagingTemplate;
	private final ChatMessageService chatMessageService;

	@MessageMapping("/chat")
	public void processMessage(@Payload ChatMessage chatMessage) {
		ChatMessage savedMsg = chatMessageService.save(chatMessage);
		messagingTemplate.convertAndSendToUser(chatMessage.getRecipientId(), "/queue/messages",
				new ChatNotification(savedMsg.getId(), savedMsg.getSenderId(), savedMsg.getRecipientId(), savedMsg.getContent()));
	}

	@GetMapping("/messages/{senderId}/{recipientId}")
	public ResponseEntity<List<ChatMessage>> findChatMessages(@PathVariable String senderId, @PathVariable String recipientId) {
		return ResponseEntity.ok(chatMessageService.findChatMessages(senderId, recipientId));
	}
}
