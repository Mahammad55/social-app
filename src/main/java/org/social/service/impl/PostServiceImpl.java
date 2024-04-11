package org.social.service.impl;

import lombok.RequiredArgsConstructor;
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
    public List<PostResponse> getAllPostsByUsername(String username) {
        User user = userRepository.findUserByUsername(username).get();
        List<Post> allPosts = postRepository.findAllByUser(user);
        return allPosts.stream().map(postMapper::entityToResponse).toList();
    }
}