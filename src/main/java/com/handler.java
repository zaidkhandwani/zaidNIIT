package com;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.User;

@Component
public class handler {

	public User initFlow(){
		return new User();
	}

	
}