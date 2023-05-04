package com.project.newsreadingweb.services;

import com.project.newsreadingweb.entities.Post;
import com.project.newsreadingweb.mappers.PostMapper;
import com.project.newsreadingweb.model.PostDTO;
import com.project.newsreadingweb.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public List<PostDTO> listPost(){

       List<Post> postList = postRepository.findAll();

        return postList.stream()
                .map(postMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public Optional<PostDTO> getPostById(UUID id)
    {
        return postRepository.findById(id)
                .map(postMapper::toDTO);
    }
    @Override
    public PostDTO saveNewPost(PostDTO postDTO) {
        return postMapper.toDTO(postRepository.save(postMapper.toEntity(postDTO)));
    }
    @Override
    public boolean deleteById(UUID Id){
        if (postRepository.existsById(Id)) {
            postRepository.deleteById(Id);
            return true;
        }
        return false;
    }
    @Override
    public Optional<PostDTO> updatePostById(UUID postId, PostDTO postDTO) {
        AtomicReference<Optional<PostDTO>> atomicReference = new AtomicReference<>();

        postRepository.findById(postId).ifPresentOrElse(foundPost -> {
            foundPost.setTitle(postDTO.getTitle());
            foundPost.setDescription(postDTO.getDescription());
            foundPost.setImageUrl(postDTO.getImageUrl());
            foundPost.setAuthorRelatedInfo(postDTO.getAuthorRelatedInfo());
            foundPost.setLikeCount(postDTO.getLikeCount());
            foundPost.setUpdatedAt(LocalDateTime.now());
            atomicReference.set(Optional.of(postMapper
                    .toDTO(postRepository.save(foundPost))));
        }, () -> {
            atomicReference.set(Optional.empty());
        });

        return atomicReference.get();
    }
}
