package com.blog.demo.service.impl;

import com.blog.demo.entity.Comment;
import com.blog.demo.exceptions.ResourceNotFoundException;
import com.blog.demo.payload.CommentDTO;
import com.blog.demo.repository.CommentRepository;
import com.blog.demo.service.CommentService;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDTO createComment(CommentDTO comment) {
        modelMapper.map(comment, Comment.class);
        return null;
    }

    @Override
    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("no such data found for id:" + id));
        commentRepository.delete(comment);

    }

    @Override
    public List<CommentDTO> getAllComments() {
        List<Comment> allcomments = commentRepository.findAll();
        List<CommentDTO> commentDtos = allcomments.stream().map(e -> modelMapper.map(e, CommentDTO.class)).collect(Collectors.toList());
        return commentDtos;
    }

    @Override
    public CommentDTO getCommentById(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("no such data found for id " + id));

        return modelMapper.map(comment,CommentDTO.class);
    }
}
