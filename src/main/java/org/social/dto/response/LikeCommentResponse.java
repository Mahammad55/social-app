package org.social.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LikeCommentResponse {
    private Long id;

    private String commentedUsername;

    private String likedUsername;

    private LocalDateTime createdAt;
}
