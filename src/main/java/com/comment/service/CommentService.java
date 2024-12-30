package com.comment.service;

import com.comment.DTO.CommentDTO;
import com.comment.controller.CommentController;
import org.springframework.http.ResponseEntity;

public interface CommentService {

    public CommentDTO savecomment(CommentDTO commentDTO);
}
