package com.example.tasktracker.entities;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@Table(name = "task")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "task_name")
	private String taskName;

	@ManyToOne
	@JoinColumn(name = "manager_id")
	private User manager;

	@ManyToOne
	@JoinColumn(name = "developer_id")
	private User developer;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;


}
