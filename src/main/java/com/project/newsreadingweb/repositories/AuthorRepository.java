package com.project.newsreadingweb.repositories;

import com.project.newsreadingweb.entities.Author;
import com.project.newsreadingweb.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "authors", path = "authors")
public interface AuthorRepository extends JpaRepository<Author, UUID> {
}