package com.example.tasktracker.entities;


import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Component
@Scope("prototype")
@Data
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "project_id")
	private Long projectId;

	private String projectName;

	@ManyToOne
	@JoinColumn(name = "manager")
	private Manager manager;

	@ManyToMany(mappedBy = "projects")
	transient private List<Developer> developers = new ArrayList<>();
	@OneToMany
	private List<Task> tasks = new ArrayList<>();

	public void addDeveloper(Developer dev) {
		developers.add(dev);
	}

	public void addTask(Task task) {
		tasks.add(task);
	}

	@Override
	public String toString() {
		return "Project{" +
				"projectId=" + projectId +
				", projectName='" + projectName + '\'' +
				", manager=" + manager +
				'}';
	}
}
