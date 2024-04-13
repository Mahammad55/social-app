package org.social.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.social.dto.request.CommentRequest;
import org.social.dto.response.CommentResponse;
import org.social.entity.Comment;
import org.social.entity.Post;
import org.social.entity.User;
import org.social.mapper.CommentMapper;
import org.social.repository.CommentRepository;
import org.social.repository.PostRepository;
import org.social.repository.UserRepository;
import org.social.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    private final PostRepository postRepository;

    private final UserRepository userRepository;

    private final CommentMapper commentMapper;

    @Override
    public List<CommentResponse> getAllCommentByPostId(Long postId) {
        Post post = postRepository.findById(postId).get();
        List<Comment> comments = commentRepository.findAllByPost(post).get();
        return comments.stream().map(commentMapper::entityToResponse).toList();
    }

    @Override
    public List<CommentResponse> getAllCommentByUserId(String username) {
        User user = userRepository.findUserByUsername(username).get();
        List<Comment> comments = commentRepository.findAllByUser(user).get();
        return comments.stream().map(commentMapper::entityToResponse).toList();
    }

    @Override
    @Transactional
    public CommentResponse saveCommentByUserAndPostId(String username, Long postId, CommentRequest commentRequest) {
        User user = userRepository.findUserByUsername(username).get();
        Post post = postRepository.findById(postId).get();
        Comment comment = commentMapper.requestToEntity(commentRequest);
        comment.setUser(user);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        return commentMapper.entityToResponse(savedComment);
    }
}
