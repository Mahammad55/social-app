package org.social.controller;

import lombok.RequiredArgsConstructor;
import org.social.dto.response.CommentResponse;
import org.social.service.CommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/post/{id}")
    public List<CommentResponse> getAllCommentByPostId(@PathVariable(value = "id") Long postId) {
        return commentService.getAllCommentByPostId(postId);
    }

    @GetMapping("/user/{username}")
    public List<CommentResponse> getAllCommentByUser(@PathVariable String username) {
        return commentService.getAllCommentByUserId(username);
    }
}
