package org.social.service;

import org.social.dto.request.UserRequest;
import org.social.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse saveUser(UserRequest userRequest);

    List<UserResponse> getAllUsers();

    UserResponse getUserByUsername(String username);

    UserResponse updateUserByUsername(String username, UserRequest userRequest);

    Boolean deleteUserByUsername(String username);
}
