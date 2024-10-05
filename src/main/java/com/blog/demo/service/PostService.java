package com.blog.demo.service;

import com.blog.demo.payload.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PostService {
    PostDTO createPost(PostDTO postDto);

    void deletePost(Long id);

    List<PostDTO> fetchALLPost();
    PostDTO getPostById(Long id);
    PostDTO updatePostById(Long id, PostDTO postDto);
}
