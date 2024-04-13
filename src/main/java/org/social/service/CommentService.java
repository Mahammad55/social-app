package org.social.service;

import org.social.dto.request.CommentRequest;
import org.social.dto.response.CommentResponse;

import java.util.List;

public interface CommentService {
    List<CommentResponse> getAllCommentByPostId(Long id);

    List<CommentResponse> getAllCommentByUserId(String username);

    CommentResponse saveCommentByUserAndPostId(String username, Long postId, CommentRequest commentRequest);

    CommentResponse updateCommentByUserAndPostId(String username, Long postId, Long commentId, CommentRequest commentRequest);

    boolean deleteCommentByUserAndPostId(String username, Long postId, Long commentId);
}
