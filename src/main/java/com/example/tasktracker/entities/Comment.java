package com.example.tasktracker.entities;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Component
@Scope("prototype")
@Data
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "comment_id")
	private Long commentId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new Date();

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "author_id")
	private User author;

	private String commentText;
}
