package com.project.newsreadingweb.services;

import com.project.newsreadingweb.entities.Post;
import com.project.newsreadingweb.model.PostDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostService {
    List<PostDTO> listPost();

    Optional<PostDTO> getPostById(UUID Id);

    PostDTO saveNewPost(PostDTO postDTO);

    boolean deleteById(UUID Id);

    Optional<PostDTO> updatePostById(UUID postId, PostDTO postDTO);
}
