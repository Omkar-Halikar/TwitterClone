package com.example.twitterclone.repository;

import com.example.twitterclone.model.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,String> {
    List<Post> findAllByUserId(String user_id);
}
