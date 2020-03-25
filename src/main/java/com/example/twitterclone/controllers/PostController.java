package com.example.twitterclone.controllers;

import com.example.twitterclone.model.domain.Post;
import com.example.twitterclone.model.domain.User;
import com.example.twitterclone.model.dto.PostDto;
import com.example.twitterclone.model.dto.UserDto;
import com.example.twitterclone.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
public class PostController {


    @Autowired
    PostRepository postRepository;

    @PostMapping("/create")
    public PostDto createPost(@RequestBody PostDto postDto){
        return toPostDtoFromPost(postRepository.save(toPostFromPostDto(postDto)));
    }

    @GetMapping("/user/{id}")
    public List<PostDto> getUserPosts(@PathVariable("id") String id){
        List<Post> userPosts= postRepository.findAllByUserId(id);
        return userPosts
                .stream()
                .map(post -> toPostDtoFromPost(post))
                .collect(Collectors.toList());
    }
    private Post toPostFromPostDto(PostDto postDto){
        Post post = new Post();
        post.setDescription(postDto.getDescription());
        User user = new User();
        user.setId(postDto.getUserId());
        post.setUser(user);
        return post;
    }

    private PostDto toPostDtoFromPost(Post post){
        PostDto postDto = new PostDto();
        postDto.setDescription(post.getDescription());
        postDto.setUserId(post.getUser().getId());
        postDto.setId(post.getId());
        return postDto;
    }
}
