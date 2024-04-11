package org.social.service.impl;

import lombok.RequiredArgsConstructor;
import org.social.dto.request.PostRequest;
import org.social.dto.response.PostResponse;
import org.social.entity.Post;
import org.social.entity.User;
import org.social.mapper.PostMapper;
import org.social.repository.PostRepository;
import org.social.repository.UserRepository;
import org.social.service.PostService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    private final UserRepository userRepository;

    private final PostMapper postMapper;

    @Override
    public List<PostResponse> getAllPosts() {
        List<Post> allPosts = postRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        return allPosts.stream().map(postMapper::entityToResponse).toList();
    }

    @Override
    public List<PostResponse> getAllPostsByUser(String username) {
        User user = userRepository.findUserByUsername(username).get();
        List<Post> allPosts = postRepository.findAllByUser(user);
        return allPosts.stream().map(postMapper::entityToResponse).toList();
    }

    @Override
    public PostResponse savePostByUser(String username, PostRequest postRequest) {
        User user = userRepository.findUserByUsername(username).get();
        Post post = postMapper.requestToEntity(postRequest);
        post.setUser(user);
        Post savedPost = postRepository.save(post);
        return postMapper.entityToResponse(savedPost);
    }

    @Override
    public PostResponse updatePostById(Long postId, PostRequest postRequest) {
        Post post = postRepository.findById(postId).get();
        Optional.ofNullable(postRequest.getText()).ifPresent(post::setText);
        Post savedPost = postRepository.save(post);
        return postMapper.entityToResponse(savedPost);
    }

    @Override
    public Boolean deletePostById(Long postId) {
        try {
            Post post = postRepository.findById(postId).get();
            postRepository.delete(post);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}