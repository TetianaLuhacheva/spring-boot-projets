package fr.tetiana.chain_prof.repository;

import fr.tetiana.chain_prof.model.Post;
import fr.tetiana.chain_prof.model.Sub;
import fr.tetiana.chain_prof.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubreddit(Sub subreddit);
    List<Post> findByUser(User user);
}