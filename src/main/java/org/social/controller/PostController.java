package org.social.controller;

import lombok.RequiredArgsConstructor;
import org.social.dto.response.PostResponse;
import org.social.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public List<PostResponse> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("{username}")
    public List<PostResponse> getAllPostsBuUsername(@PathVariable String username){
        return postService.getAllPostsByUsername(username);
    }

}
