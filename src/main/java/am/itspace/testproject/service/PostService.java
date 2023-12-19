package am.itspace.testproject.service;

import am.itspace.testproject.entity.Post;

import java.util.Optional;

public interface PostService {
    Post createPost(Post post);

    Optional<Post> findById(Integer id);
}
