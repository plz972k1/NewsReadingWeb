package com.project.newsreadingweb.repositories;

import com.project.newsreadingweb.entities.Post;
import com.project.newsreadingweb.entities.PostWithAuthorProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "posts", path = "posts", excerptProjection = PostWithAuthorProjection.class)
public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findByTitleContainingOrBodyContaining(String titleKeyword, String bodyKeyword);

    @Modifying
    @Query("update Post p set p.isLike = true where p.id = ?1")
    int likeAndUnlike(String id);
}
