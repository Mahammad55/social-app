package org.social.service.impl;

import lombok.RequiredArgsConstructor;
import org.social.dto.response.LikeCommentResponse;
import org.social.dto.response.LikePostResponse;
import org.social.entity.Like;
import org.social.entity.Post;
import org.social.entity.User;
import org.social.mapper.LikeMapper;
import org.social.repository.CommentRepository;
import org.social.repository.LikeRepository;
import org.social.repository.PostRepository;
import org.social.repository.UserRepository;
import org.social.service.LikeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;

    private final UserRepository userRepository;

    private final CommentRepository commentRepository;

    private final PostRepository postRepository;

    private final LikeMapper likeMapper;

    @Override
    public List<LikePostResponse> getAllLikeByUser(String username) {
        List<Like> likeList = likeRepository.findAllByUserUsername(username).get();
        return likeList.stream().map(likeMapper::entityToPostResponse).toList();
    }

    @Override
    public List<LikePostResponse> getAllLikeByPost(Long postId) {
        List<Like> likeList = likeRepository.findAllByPostId(postId).get();
        return likeList.stream().map(likeMapper::entityToPostResponse).toList();
    }

    @Override
    public List<LikeCommentResponse> getAllLikeByComment(Long commentId) {
        List<Like> likeList = likeRepository.findAllByCommentId(commentId).get();
        return likeList.stream().map(likeMapper::entityToCommentResponse).toList();
    }

    @Override
    public LikePostResponse saveLikeByPost(String username, Long postId) {
        User user = userRepository.findUserByUsername(username).get();
        Post post = postRepository.findById(postId).get();
        Like like = new Like();
        like.setUser(user);
        like.setPost(post);
        Like savedLike = likeRepository.save(like);
        return likeMapper.entityToPostResponse(savedLike);
    }
}
