package org.social.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.social.dto.response.LikeCommentResponse;
import org.social.dto.response.LikePostResponse;
import org.social.entity.Like;

@Mapper(componentModel = "spring")
public interface LikeMapper {

    @Mapping(target = "likedUsername", source = "like.user.username")
    @Mapping(target = "postedUsername", source = "like.post.user.username")
    LikePostResponse entityToPostResponse(Like like);

    @Mapping(target = "likedUsername", source = "like.user.username")
    @Mapping(target = "commentedUsername", source = "like.comment.user.username")
    LikeCommentResponse entityToCommentResponse(Like like);
}
