package org.social.service.impl;

import lombok.RequiredArgsConstructor;
import org.social.dto.request.UserRequest;
import org.social.dto.response.UserResponse;
import org.social.entity.User;
import org.social.mapper.UserMapper;
import org.social.repository.UserRepository;
import org.social.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserResponse saveUser(UserRequest userRequest) {
        User user = userMapper.requestToEntity(userRequest);
        User savedUser = userRepository.save(user);
        return userMapper.entityToResponse(savedUser);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream().map(userMapper::entityToResponse).toList();
    }

    @Override
    public UserResponse getUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username).get();
        return userMapper.entityToResponse(user);
    }
}
