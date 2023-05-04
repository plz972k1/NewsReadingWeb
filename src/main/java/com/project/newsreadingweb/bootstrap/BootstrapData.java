package com.project.newsreadingweb.bootstrap;

import com.project.newsreadingweb.entities.Post;
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
                    .description("Cat in galaxy")
                    .imageUrl("null")
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .authorRelatedInfo("James Brown")
                    .likeCount(100)
                    .build();

            Post post2 = Post.builder()
                    .title("Red Cabbage")
                    .description("Cabbage with red")
                    .imageUrl("null")
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .authorRelatedInfo("Mason Mount")
                    .likeCount(7)
                    .build();

            Post post3 = Post.builder()
                    .title("Sunshine City")
                    .description("City with sunshine")
                    .imageUrl("null")
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .authorRelatedInfo("John Martens")
                    .likeCount(3379)
                    .build();

            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);
        }

    }


}
