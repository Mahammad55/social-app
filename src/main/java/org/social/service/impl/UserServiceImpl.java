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
import java.util.Optional;

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
    @Transactional(rollbackFor = Exception.class)
    public List<UserResponse> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream().map(userMapper::entityToResponse).toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserResponse getUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username).get();
        return userMapper.entityToResponse(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserResponse updateUserByUsername(String username, UserRequest userRequest) {
        User user = userRepository.findUserByUsername(username).get();
        User requestUser = userMapper.requestToEntity(userRequest);
        User updateUser = updateUser(user, requestUser);
        User savedUser = userRepository.save(updateUser);
        return userMapper.entityToResponse(savedUser);
    }

    @Override
    public Boolean deleteUserByUsername(String username) {
        try {
            User user = userRepository.findUserByUsername(username).get();
            userRepository.delete(user);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    private User updateUser(User user, User requestUser) {
        Optional.ofNullable(requestUser.getName()).ifPresent(user::setName);
        Optional.ofNullable(requestUser.getSurname()).ifPresent(user::setSurname);
        Optional.ofNullable(requestUser.getBirthDate()).ifPresent(user::setBirthDate);
        return user;
    }
}
