package com.project.newsreadingweb.repositories;

import com.project.newsreadingweb.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "posts", path = "posts")
@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
}
