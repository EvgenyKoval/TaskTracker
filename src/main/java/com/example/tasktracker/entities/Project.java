package com.example.tasktracker.entities;


import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Component
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "priject_id")
	private Long projectId;

	private String prijectName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager")
	private Manager manager;

	@ManyToMany(mappedBy = "projects")
	private Set<Developer> developers = new HashSet<>();

	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private Set<Task> task = new HashSet<>();

	public Project() {
	}

	public Project(String prijectName, Manager manager, Set<Developer> developers, Set<Task> task) {
		this.prijectName = prijectName;
		this.manager = manager;
		this.developers = developers;
		this.task = task;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getPrijectName() {
		return prijectName;
	}

	public void setPrijectName(String prijectName) {
		this.prijectName = prijectName;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Set<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(Set<Developer> developers) {
		this.developers = developers;
	}

	public Set<Task> getTask() {
		return task;
	}

	public void setTask(Set<Task> task) {
		this.task = task;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Project project = (Project) o;

		if (projectId != null ? !projectId.equals(project.projectId) : project.projectId != null) return false;
		if (prijectName != null ? !prijectName.equals(project.prijectName) : project.prijectName != null) return false;
		if (manager != null ? !manager.equals(project.manager) : project.manager != null) return false;
		if (developers != null ? !developers.equals(project.developers) : project.developers != null) return false;
		return task != null ? task.equals(project.task) : project.task == null;
	}

	@Override
	public int hashCode() {
		int result = projectId != null ? projectId.hashCode() : 0;
		result = 31 * result + (prijectName != null ? prijectName.hashCode() : 0);
		result = 31 * result + (manager != null ? manager.hashCode() : 0);
		result = 31 * result + (developers != null ? developers.hashCode() : 0);
		result = 31 * result + (task != null ? task.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Project{" +
				"projectId=" + projectId +
				", prijectName='" + prijectName + '\'' +
				", manager=" + manager +
				", developers=" + developers +
				", task=" + task +
				'}';
	}
}
