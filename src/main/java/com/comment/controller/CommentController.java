package com.comment.controller;

import com.comment.DTO.CommentDTO;
import com.comment.service.CommentService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Api/v1/Comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    //http://localhost:8081/Api/v1/Comment/savecomment
    @PostMapping("/savecomment")
    public ResponseEntity<?> savecomment(@RequestBody CommentDTO commentDTO){
    CommentDTO commentDTO1= commentService.savecomment(commentDTO);
    if (commentDTO1==null){
        return new ResponseEntity<>("Post ID "+commentDTO.getPostid()+"is not found",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(commentDTO1, HttpStatus.CREATED);
    }


}
