package com.sanju.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatResponse{
    public Long id;
    public String name;
    public String image;
    public String status;
    public List<Message> messages;
    public String lastSeen;
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Message{
    	public String text;
    	public Long ownerId;
    	public Object createdAt;
    }
}
