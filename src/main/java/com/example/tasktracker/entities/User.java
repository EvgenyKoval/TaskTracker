package com.example.tasktracker.entities;


import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
@Scope("prototype")
@Data
public abstract class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;
	private String name;
	private String email;
	@OneToOne
	@JoinColumn(name = "role_id")
	private Role role;
	@OneToMany
	private List<Comment> comments = new ArrayList<>();


	public void addComment(Comment comment) {
		comments.add(comment);
	}
	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", role=" + role +
				'}';
	}
}

