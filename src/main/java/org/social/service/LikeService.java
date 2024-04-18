package org.social.service;

import org.social.dto.response.LikePostResponse;

import java.util.List;

public interface LikeService {
    List<LikePostResponse> getAllLikeByUser(String username);
}
