package com.project.newsreadingweb.repositories;

import com.project.newsreadingweb.entities.PostWithAuthorProjection;
import com.project.newsreadingweb.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "posts", path = "posts", excerptProjection = PostWithAuthorProjection.class)
public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findByTitleContainingOrBodyContaining(String titleKeyword, String bodyKeyword);
}
