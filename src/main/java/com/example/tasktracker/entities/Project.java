package com.example.tasktracker.entities;


import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Scope("request")
@Data
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "priject_id", nullable = false)
	private Long projectId;
	private String prijectName;
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "user_id")
	private User manager;
	//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "user_id")
	private User developers;
	//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "task_id")
	private Task task;
}
