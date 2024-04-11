package org.social.controller;

import lombok.RequiredArgsConstructor;
import org.social.dto.request.UserRequest;
import org.social.dto.response.UserResponse;
import org.social.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserResponse saveUser(@RequestBody UserRequest userRequest) {
        return userService.saveUser(userRequest);
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{username}")
    public UserResponse getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);
    }
}
