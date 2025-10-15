package com.practice.springboot.prod_ready_features.prod_ready_features.controllers;

import com.practice.springboot.prod_ready_features.prod_ready_features.DTO.PostDTO;
import com.practice.springboot.prod_ready_features.prod_ready_features.servicies.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @PostMapping()
    public PostDTO createPosts(@RequestBody PostDTO postDTO){
        return postService.createPost(postDTO);
    }

    @GetMapping("/all")
    public List<PostDTO> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }
}
