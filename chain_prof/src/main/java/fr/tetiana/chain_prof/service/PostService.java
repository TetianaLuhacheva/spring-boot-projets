package fr.tetiana.chain_prof.service;

import java.util.List;

import fr.tetiana.chain_prof.model.Post;
import fr.tetiana.chain_prof.model.Sub;
import fr.tetiana.chain_prof.model.User;

public interface PostService {
    List<Post> findAllBySubreddit(Sub subreddit);
    List<Post> findByUser(User user);
}
