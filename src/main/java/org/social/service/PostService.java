package org.social.service;

import org.social.dto.response.PostResponse;

import java.util.List;

public interface PostService {
    List<PostResponse> getAllPosts();

    List<PostResponse> getAllPostsByUsername(String username);
}
