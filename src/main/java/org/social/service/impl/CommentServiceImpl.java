package org.social.service.impl;

import lombok.RequiredArgsConstructor;
import org.social.dto.response.CommentResponse;
import org.social.entity.Comment;
import org.social.entity.Post;
import org.social.mapper.CommentMapper;
import org.social.repository.CommentRepository;
import org.social.repository.PostRepository;
import org.social.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    private final PostRepository postRepository;

    private final CommentMapper commentMapper;

    @Override
    public List<CommentResponse> getAllCommentByPostId(Long id) {
        Post post = postRepository.findById(id).get();
        List<Comment> comments = commentRepository.findAllByPost(post).get();
        return comments.stream().map(commentMapper::entityToResponse).toList();
    }
}
