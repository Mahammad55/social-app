package org.social.mapper;

import org.mapstruct.Mapper;
import org.social.dto.request.UserRequest;
import org.social.dto.response.UserResponse;
import org.social.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User requestToEntity(UserRequest userRequest);

    UserResponse entityToResponse(User user);
}
