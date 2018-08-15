package com.example.tasktracker.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "project_id")
	private Long projectId;

	private String projectName;

	@ManyToOne
	@JoinColumn(name = "manager")
	private User manager;

	@ManyToMany
	@JsonIgnore
	private List<User> developers = new ArrayList<>();
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Task> tasks = new ArrayList<>();

	public void addDeveloper(User dev) {
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
