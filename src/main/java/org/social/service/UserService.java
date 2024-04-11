package org.social.service;

import org.social.dto.request.UserRequest;
import org.social.dto.response.UserResponse;

public interface UserService {
    UserResponse saveUser(UserRequest userRequest);
}
