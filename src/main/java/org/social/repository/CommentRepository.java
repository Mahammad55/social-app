package org.social.repository;

import org.social.entity.Comment;
import org.social.entity.Post;
import org.social.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<List<Comment>> findAllByPost(Post post);

    Optional<List<Comment>> findAllByUser(User user);
}
