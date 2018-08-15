package com.example.tasktracker.entities;


import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Component
@Scope("prototype")
@Data
@Table(name = "USER")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;
	private String login;
	private String password;
	private String name;
	private String email;
    @ManyToOne
    private Role role;

}

