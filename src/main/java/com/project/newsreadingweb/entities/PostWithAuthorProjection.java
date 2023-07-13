package com.project.newsreadingweb.entities;

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


    String getUserLikedPost();

    AuthorProjection getAuthor();

    List<CommentProjection> getComments();

    UserProjection getUser();


//    String getUserLikedPost();

    interface UserProjection {
        UUID getId();

        String getUsername();

        String getEmail();

    }

    interface CommentProjection {
        UUID getId();

        String getContent();

        LocalDateTime getCreatedAt();

        UserProjection getUser();
    }

    interface AuthorProjection {
        UUID getId();

        String getName();

        String getNationality();
    }
}