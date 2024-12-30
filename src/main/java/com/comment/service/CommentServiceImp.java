package com.comment.service;

import com.comment.DTO.CommentDTO;
import com.comment.DTO.Post;
import com.comment.entity.Comment;
import com.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class CommentServiceImp implements CommentService{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public CommentDTO savecomment(CommentDTO commentDTO) {
        String Comentid = null;
    String Str= "http://localhost:8080/Api/v1/post/"+commentDTO.getPostid();
    Comment comment= new Comment();

    Post forObject = restTemplate.getForObject(Str, Post.class);

    if (forObject!=null){

        Comentid = UUID.randomUUID().toString();
        Comment comment1 = DTOtoentity(commentDTO);
        comment1.setId(Comentid);
        Comment save = commentRepository.save(comment1);
        return entitytoDTO(save);

    }

    return null;



    }

    public Comment DTOtoentity(CommentDTO commentDTO){
        Comment comment= new Comment();
        comment.setName(commentDTO.getName());
        comment.setDescription(commentDTO.getDescription());
        comment.setPostid(commentDTO.getPostid());
        comment.setEmailid(commentDTO.getEmailid());
        return comment;
    }

    public CommentDTO entitytoDTO(Comment comment){
        CommentDTO commentDTO= new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setName(comment.getName());
        commentDTO.setDescription(comment.getDescription());
        commentDTO.setEmailid(comment.getEmailid());
        commentDTO.setPostid(comment.getPostid());
        return commentDTO;
    }

}
