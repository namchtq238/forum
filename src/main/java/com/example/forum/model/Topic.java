package com.example.forum.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Stack;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topic extends Entry {
	private Stack<Message> messages = new Stack<>();
	private Category category;

}
