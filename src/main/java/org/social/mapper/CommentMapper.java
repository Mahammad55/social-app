package org.social.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.social.dto.request.CommentRequest;
import org.social.dto.response.CommentResponse;
import org.social.entity.Comment;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "postId", source = "post.id")
    CommentResponse entityToResponse(Comment comment);

    Comment requestToEntity(CommentRequest commentRequest);
}
