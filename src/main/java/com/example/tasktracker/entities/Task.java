package com.example.tasktracker.entities;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Scope("prototype")
@Data
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id")
	private Long taskId;
	private String taskName;
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Manager manager;

	@ManyToOne
	@JoinColumn(name = "developer_id")
	private Developer developer;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;


}
