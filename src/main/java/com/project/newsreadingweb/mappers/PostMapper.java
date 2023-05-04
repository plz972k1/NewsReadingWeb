package com.project.newsreadingweb.mappers;

import com.project.newsreadingweb.entities.Post;
import com.project.newsreadingweb.model.PostDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PostMapper {
    Post toEntity(PostDTO dto);
    PostDTO toDTO(Post post);
}
