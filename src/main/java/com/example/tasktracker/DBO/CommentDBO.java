package com.example.tasktracker.DBO;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDBO {
    private Long commentId;
    private Date date = new Date();
//    private User author;
    private String commentText;
}
