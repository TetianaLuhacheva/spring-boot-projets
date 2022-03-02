package fr.tetiana.chain_prof.repository;

import fr.tetiana.chain_prof.model.Comment;
import fr.tetiana.chain_prof.model.Post;
import fr.tetiana.chain_prof.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
    List<Comment> findAllByUser(User user);
}