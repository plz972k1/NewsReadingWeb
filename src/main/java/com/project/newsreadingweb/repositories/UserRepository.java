package com.project.newsreadingweb.repositories;

import com.project.newsreadingweb.entities.Post;
import com.project.newsreadingweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
}