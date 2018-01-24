package com.example.tasktracker.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Component
@Data
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "task_id", nullable = false)
	private Long taskId;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id", nullable = false)
	@Column(name = "owner")
	private User owner;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	@Column(name = "developers")
	private List<User> developers;

}
