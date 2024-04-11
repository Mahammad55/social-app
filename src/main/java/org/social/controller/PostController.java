package org.social.controller;

import lombok.RequiredArgsConstructor;
import org.social.dto.request.PostRequest;
import org.social.dto.response.PostResponse;
import org.social.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public List<PostResponse> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("{username}")
    public List<PostResponse> getAllPostsByUser(@PathVariable String username) {
        return postService.getAllPostsByUser(username);
    }

    @PostMapping("{username}")
    public PostResponse savePostByUser(@PathVariable String username, @RequestBody PostRequest postRequest) {
        return postService.savePostByUser(username, postRequest);
    }

    @PutMapping("{id}")
    public PostResponse updatePostById(@PathVariable(value = "id") Long postId, @RequestBody PostRequest postRequest) {
        return postService.updatePostById(postId,postRequest);
    }
}
