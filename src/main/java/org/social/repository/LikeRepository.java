package org.social.repository;

import org.social.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<List<Like>> findAllByUserUsername(String username);

    Optional<List<Like>> findAllByPostId(Long postId);

    Optional<List<Like>> findAllByCommentId(Long commentId);
}
