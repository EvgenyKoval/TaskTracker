package com.example.tasktracker.entities;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Component
@Scope("prototype")
@Data
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id")
	private Long taskId;
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
