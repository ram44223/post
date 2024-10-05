package com.blog.demo.service;


import com.blog.demo.payload.CommentDTO;

import java.util.List;

public interface CommentService {
    CommentDTO createComment(CommentDTO comment);

    void deleteComment(Long id);
    List<CommentDTO> getAllComments();
    CommentDTO getCommentById(Long id);

    
}
