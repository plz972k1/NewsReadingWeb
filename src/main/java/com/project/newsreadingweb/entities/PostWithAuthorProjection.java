package com.project.newsreadingweb.entities;

import com.project.newsreadingweb.entities.Comment;
import com.project.newsreadingweb.entities.Post;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Projection(name = "postWithAuthor", types = {Post.class})
public interface PostWithAuthorProjection {
    UUID getId();
    String getTitle();
    String getBody();
    String getThumbnail();
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
    String getLink();
    boolean isLike();
    boolean isBookmarked();
    AuthorProjection getAuthor();
    List<CommentProjection> getComments();
    UserProjection getUser();
    interface UserProjection {
        UUID getId();
        String getUsername();
        String getEmail();

    }

    interface CommentProjection {
        UUID getId();
        String getContent();
        LocalDateTime getCreatedAt();
    }

    interface AuthorProjection {
        UUID getId();
        String getName();
        String getNationality();
    }
}