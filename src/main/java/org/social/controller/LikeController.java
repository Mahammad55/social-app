package org.social.controller;

import lombok.RequiredArgsConstructor;
import org.social.dto.response.LikeCommentResponse;
import org.social.dto.response.LikePostResponse;
import org.social.service.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/likes")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @GetMapping("/user/{username}")
    public List<LikePostResponse> getAllLikeByUser(@PathVariable String username) {
        return likeService.getAllLikeByUser(username);
    }

    @GetMapping("/post/{id}")
    public List<LikePostResponse> getAllLikeByPost(@PathVariable(value = "id") Long postId) {
        return likeService.getAllLikeByPost(postId);
    }

    @GetMapping("/comment/{id}")
    public List<LikeCommentResponse> getAllLikeByComment(@PathVariable(value = "id") Long commentId) {
        return likeService.getAllLikeByComment(commentId);
    }

    @PostMapping("/post/{username}/{id}")
    public LikePostResponse saveLikeByPost(@PathVariable String username, @PathVariable(value = "id") Long postId) {
        return likeService.saveLikeByPost(username, postId);
    }

    @PostMapping("/comment/{username}/{id}")
    public LikeCommentResponse saveLikeByComment(@PathVariable String username, @PathVariable(value = "id") Long commentId) {
        return likeService.saveLikeByComment(username, commentId);
    }
}