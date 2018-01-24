package com.example.tasktracker.entities;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Scope("request")
@Data
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "role_id")
	private Long roleId;
	private String role;
}
