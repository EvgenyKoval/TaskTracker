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

	private String prijectName;

	@ManyToOne
	@JoinColumn(name = "manager")
	private User manager;

	@OneToMany
	private List<User> developers = new ArrayList<>();

	public void addDeveloper(User dev) {
		developers.add(dev);
	}

}
