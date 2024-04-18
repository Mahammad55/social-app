package org.social.service;

import org.social.dto.response.LikeCommentResponse;
import org.social.dto.response.LikePostResponse;

import java.util.List;

public interface LikeService {
    List<LikePostResponse> getAllLikeByUser(String username);

    List<LikePostResponse> getAllLikeByPost(Long postId);

    List<LikeCommentResponse> getAllLikeByComment(Long commentId);

    LikePostResponse saveLikeByPost(String username, Long postId);

    LikeCommentResponse saveLikeByComment(String username, Long commentId);
}
