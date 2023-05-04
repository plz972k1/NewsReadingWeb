package com.project.newsreadingweb.controller;

import com.project.newsreadingweb.entities.Post;
import com.project.newsreadingweb.model.PostDTO;
import com.project.newsreadingweb.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PostController {
    public static final String POST_PATH = "/post";
    public static final String POST_PATH_ID = POST_PATH + "/{postId}";
    private final PostService postService;

    @GetMapping(value = POST_PATH)
    public List<PostDTO> listPost()
    {
        return postService.listPost();
    }

    @GetMapping(value = POST_PATH_ID)
    public PostDTO getPostById(@PathVariable("postId") UUID postId){

        return postService.getPostById(postId).orElseThrow();
    }

    @PostMapping(POST_PATH)
    public ResponseEntity handlePost(@Validated @RequestBody PostDTO postDTO){

        PostDTO savedPost = postService.saveNewPost(postDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", POST_PATH + "/" + savedPost.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @DeleteMapping(POST_PATH_ID)
    public ResponseEntity deleteById(@PathVariable("postId") UUID postId){

        postService.deleteById(postId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @PutMapping(POST_PATH_ID)
    public ResponseEntity updateById(@PathVariable("postId")UUID postId, @Validated @RequestBody PostDTO postDTO){

        postService.updatePostById(postId, postDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
