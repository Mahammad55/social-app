package org.social.service;

import org.social.dto.response.CommentResponse;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface CommentService {
    List<CommentResponse> getAllCommentByPostId(Long id);
}
