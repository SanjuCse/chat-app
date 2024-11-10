package com.sanju.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sanju.common.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class User {
	@Id
	private String nickName;
	private String fullName;
	private Status status;
}
