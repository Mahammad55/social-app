package org.social.controller;

import lombok.RequiredArgsConstructor;
import org.social.dto.request.CommentRequest;
import org.social.dto.response.CommentResponse;
import org.social.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{username}/{id}")
    public CommentResponse saveCommentByUserAndPostId(@PathVariable String username, @PathVariable(value = "id") Long postId,
                                                      @RequestBody CommentRequest commentRequest) {
        return commentService.saveCommentByUserAndPostId(username, postId, commentRequest);
    }

    @PutMapping("/{username}/{postId}/{commentId}")
    public CommentResponse updateCommentByUserAndPostId(@PathVariable String username, @PathVariable Long postId, @PathVariable Long commentId,
                                                        @RequestBody CommentRequest commentRequest) {
        return commentService.updateCommentByUserAndPostId(username, postId, commentId, commentRequest);
    }

    @DeleteMapping("/{username}/{postId}/{commentId}")
    public ResponseEntity<String> deleteCommentByUserAndPostId(@PathVariable String username, @PathVariable Long postId, @PathVariable Long commentId) {
        if (commentService.deleteCommentByUserAndPostId(username, postId, commentId)) {
            return ResponseEntity.ok("Comment has been successfully deleted!");
        }
        return ResponseEntity.badRequest().body("Comment can not deleted!");
    }
}
