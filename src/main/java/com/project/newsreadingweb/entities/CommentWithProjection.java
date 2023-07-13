package com.project.newsreadingweb.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.UUID;

@Projection(name = "commentWithProject", types = {Comment.class})
public interface CommentWithProjection {

    UserProjection getUser();


    interface UserProjection {
        UUID getId();

        String getUsername();

        String getEmail();

    }
}
