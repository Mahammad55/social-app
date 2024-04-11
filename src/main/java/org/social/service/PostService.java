package org.social.service;

import org.social.dto.request.PostRequest;
import org.social.dto.response.PostResponse;

import java.util.List;

public interface PostService {
    List<PostResponse> getAllPosts();

    List<PostResponse> getAllPostsByUser(String username);

    PostResponse savePostByUser(String username, PostRequest postRequest);

    PostResponse updatePostById(Long postId, PostRequest postRequest);

    Boolean deletePostById(Long postId);
}
