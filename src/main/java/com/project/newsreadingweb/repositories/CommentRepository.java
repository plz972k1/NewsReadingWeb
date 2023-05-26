package com.project.newsreadingweb.repositories;

import com.project.newsreadingweb.entities.Comment;
import com.project.newsreadingweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "comments", path = "comments")
@Repository
public interface CommentRepository extends  JpaRepository<Comment, UUID> {
}
