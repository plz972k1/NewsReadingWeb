package com.project.newsreadingweb.Projections;

import com.project.newsreadingweb.entities.Post;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;
import java.util.UUID;

@Projection(name = "postWithAuthor", types = {Post.class})
public interface PostWithAuthorProjection {
    UUID getId();
    String getTitle();
    String getBody();
    String getThumbnail();
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
    String getAuthorRelatedInfo();
    boolean isLike();
    boolean isBookmarked();
    Author getAuthor();

    interface Author {
        UUID getId();
        String getName();
        String getNationality();
    }
}