package org.social.controller;

import lombok.RequiredArgsConstructor;
import org.social.service.CommentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
}
