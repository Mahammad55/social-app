package org.social.controller;

import lombok.RequiredArgsConstructor;
import org.social.dto.request.PostRequest;
import org.social.dto.response.PostResponse;
import org.social.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public List<PostResponse> getAllPost() {
        return postService.getAllPosts();
    }

    @GetMapping("{username}")
    public List<PostResponse> getAllPostByUser(@PathVariable String username) {
        return postService.getAllPostsByUser(username);
    }

    @PostMapping("{username}")
    public PostResponse savePostByUser(@PathVariable String username, @RequestBody PostRequest postRequest) {
        return postService.savePostByUser(username, postRequest);
    }

    @PutMapping("{id}")
    public PostResponse updatePostById(@PathVariable(value = "id") Long postId, @RequestBody PostRequest postRequest) {
        return postService.updatePostById(postId, postRequest);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(value = "id") Long postId) {
        if (postService.deletePostById(postId)) {
            return ResponseEntity.ok("Post has been successfully deleted!");
        }
        return ResponseEntity.badRequest().body("Post can not deleted!");
    }
}
