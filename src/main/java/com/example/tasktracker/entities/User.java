package com.example.tasktracker.entities;


import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Entity
@Component
@Scope("session")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Role role;
	//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "task_id")
	private Task task;
	@OneToMany()
	private Set<Comment> comments;

}
