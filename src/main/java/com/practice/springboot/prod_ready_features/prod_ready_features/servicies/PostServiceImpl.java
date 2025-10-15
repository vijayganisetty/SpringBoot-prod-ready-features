package com.practice.springboot.prod_ready_features.prod_ready_features.servicies;

import com.practice.springboot.prod_ready_features.prod_ready_features.DTO.PostDTO;
import com.practice.springboot.prod_ready_features.prod_ready_features.advice.ResourceNotFoundException;
import com.practice.springboot.prod_ready_features.prod_ready_features.entities.PostEntity;
import com.practice.springboot.prod_ready_features.prod_ready_features.repositories.PostRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepo postRepo;
    private final ModelMapper mapper;

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepo.findAll().
                stream()
                .map( postEntity -> mapper.map(postEntity, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        PostEntity post = mapper.map(postDTO, PostEntity.class);
        return mapper.map(postRepo.save(post),PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long id) {
        PostEntity post = postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No posts with id : "+ id));

        return mapper.map(postRepo.findById(id), PostDTO.class);
    }
}
