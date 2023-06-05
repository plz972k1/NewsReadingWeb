package com.project.newsreadingweb.bootstrap;

import com.project.newsreadingweb.entities.Author;
import com.project.newsreadingweb.entities.Post;
import com.project.newsreadingweb.repositories.AuthorRepository;
import com.project.newsreadingweb.repositories.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        loadPostData();
    }

    private final PostRepository postRepository;
    private void loadPostData() {
        if (postRepository.count() == 0){
            Post post1 = Post.builder()
                    .title("Galaxy Cat")
                    .body("Cat in galaxy")
                    .thumbnail("null")
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .link("google.com")
                    .isLike(true)
                    .isBookmarked(true)
                    .build();


            postRepository.save(post1);
        }
    }


}
