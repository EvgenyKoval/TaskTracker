package com.example.tasktracker.entities;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
@Data
@Scope("prototype")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "manager")
public class Manager extends User implements Serializable {
	@OneToMany
	transient private List<Project> createdProjects = new ArrayList<>();
	@OneToMany
	transient private List<Task> createdTasks = new ArrayList<>();

	public void addProject(Project project) {
		createdProjects.add(project);
	}

	public void addTask(Task task) {
		createdTasks.add(task);
	}

	@Override
	public String toString() {
		return "{" +
				"id:" + getId() +
				", name:'" + getName() + '\'' +
				", email:'" + getEmail() + '\'' +
				", role:" + getRole() +
				"}";

	}
}
