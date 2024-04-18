package org.social.controller;

import lombok.RequiredArgsConstructor;
import org.social.dto.response.LikePostResponse;
import org.social.service.LikeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/likes")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @GetMapping("/user/{username}")
    public List<LikePostResponse> getAllLikePostByUser(@PathVariable String username) {
        return likeService.getAllLikeByUser(username);
    }
}