package com.blog.demo.controller;

import com.blog.demo.payload.PostDTO;
import com.blog.demo.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/postController")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/createPost")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO){
        PostDTO savedPost = postService.createPost(postDTO);
        return  new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> fetchAllPost(PostDTO postDTO){
        List<PostDTO> postDTOS = postService.fetchALLPost();
        return new ResponseEntity<>(postDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long id){
        PostDTO postById = postService.getPostById(id);
        return new ResponseEntity<>(postById,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePostById( @PathVariable Long id,@RequestBody PostDTO postDTO){
        PostDTO updatedPost = postService.updatePostById(id, postDTO);
        return new ResponseEntity<>(updatedPost,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable Long id){
        postService.deletePost(id);
        return new ResponseEntity<>("post deleted successfully",HttpStatus.OK);

    }

}
