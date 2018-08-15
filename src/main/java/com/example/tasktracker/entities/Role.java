package com.example.tasktracker.entities;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Scope("prototype")
@Data
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roleId;
	private String roleName;
}
