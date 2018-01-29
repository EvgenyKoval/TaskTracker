package com.example.tasktracker.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Component
@Scope("prototype")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "developer")
public class Developer extends User {
	@ManyToMany
	@JoinTable(name = "developers_projects",
			joinColumns = @JoinColumn(name = "developer_id"),
			inverseJoinColumns = @JoinColumn(name = "project_id"))
	transient private List<Project> projects = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL)
	transient private List<Task> tasks = new ArrayList<>();

	public void addTask(Task task) {
		tasks.add(task);
	}

	public void addProject(Project project) {
		projects.add(project);
	}

	@Override
	public String toString() {
		return "Developer{" +
				"id=" + getId() +
				", name='" + getName() + '\'' +
				", email='" + getEmail() + '\'' +
				", role=" + getRole() +
				"}";
	}
}
