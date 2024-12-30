package com.comment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {
    @Id
    private String id;

    private String name;

    private String emailid;

    private String description;

    private String postid;
}
