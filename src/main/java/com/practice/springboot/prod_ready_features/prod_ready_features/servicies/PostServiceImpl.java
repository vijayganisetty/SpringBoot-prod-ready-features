package com.practice.springboot.prod_ready_features.prod_ready_features.servicies;

import com.practice.springboot.prod_ready_features.prod_ready_features.DTO.PostDTO;
import com.practice.springboot.prod_ready_features.prod_ready_features.advice.ResourceNotFoundException;
import com.practice.springboot.prod_ready_features.prod_ready_features.entities.PostEntity;
import com.practice.springboot.prod_ready_features.prod_ready_features.repositories.PostRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepo postRepo;
    private final ModelMapper mapper;
    Logger log = LoggerFactory.getLogger(PostServiceImpl.class);

    @Override
    public List<PostDTO> getAllPosts() {
        log.info("Getting all posts");
        List<PostDTO> postDTOList =  postRepo.findAll().
                stream()
                .map( postEntity -> mapper.map(postEntity, PostDTO.class))
                .collect(Collectors.toList());
        log.info("total posts {}", postDTOList.size());
        return postDTOList;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        PostEntity post = mapper.map(postDTO, PostEntity.class);
        return mapper.map(postRepo.save(post),PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long id) {
        PostEntity post = postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No posts with id : "+ id));

        return mapper.map(post, PostDTO.class);
    }

    @Override
    public PostDTO UpdatePostByID(PostDTO inputPost, Long id) {
        PostEntity post = postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No posts with id :"+ id));
        inputPost.setId(id);
        mapper.map(inputPost, post);
        return mapper.map(postRepo.save(post), PostDTO.class);

    }
}
