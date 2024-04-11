package org.social.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.social.dto.response.PostResponse;
import org.social.entity.Post;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target = "postId", source = "id")
    @Mapping(target = "username", source = "user.username")
    PostResponse entityToResponse(Post post);
}
