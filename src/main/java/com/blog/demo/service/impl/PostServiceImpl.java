package com.blog.demo.service.impl;

import com.blog.demo.entity.Post;
import com.blog.demo.exceptions.ResourceNotFoundException;
import com.blog.demo.payload.PostDTO;
import com.blog.demo.repository.PostRepository;
import com.blog.demo.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {


    private PostRepository postRepository;
    private ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDTO createPost(PostDTO postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        Post savedPost = postRepository.save(post);


        return modelMapper.map(savedPost,PostDTO.class);
    }

    @Override
    public void deletePost(Long id) {

        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Such Data found with id " + id));
        postRepository.delete(post);
    }

    @Override
    public List<PostDTO> fetchALLPost() {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> dtos = posts.stream().map(e -> modelMapper.map(e, PostDTO.class)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public PostDTO getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Such Data found with id " + id));
        return modelMapper.map(post,PostDTO.class);
    }

    @Override
    public PostDTO updatePostById(Long id , PostDTO postDTO) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No such data found for id " + id));
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());
         Post updatedPost=  postRepository.save(post);


        return modelMapper.map(updatedPost,PostDTO.class);
    }
}
