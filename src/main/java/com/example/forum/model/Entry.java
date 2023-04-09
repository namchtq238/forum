package com.example.forum.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public abstract class Entry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	private String title;
	private String content;
	private Calendar createdTime;
	@ManyToOne
	@JoinColumn(name = "creator_id")
	private User creator;


	public Entry(Long id, String title, String content, User creator) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.creator = creator;
	}
}
