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
	@Column(name = "task_id")
	private Long taskId;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "manager_id", nullable = false)
	private Manager manager;

	@ManyToMany(mappedBy = "tasks",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Developer> developers;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private Project project;

}
