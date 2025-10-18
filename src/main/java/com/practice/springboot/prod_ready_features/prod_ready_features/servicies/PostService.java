package com.practice.springboot.prod_ready_features.prod_ready_features.servicies;


import com.practice.springboot.prod_ready_features.prod_ready_features.DTO.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getAllPosts();

    PostDTO createPost(PostDTO postDTO);

    PostDTO getPostById(Long id);

    PostDTO UpdatePostByID(PostDTO postDTO, Long id);
}
