package am.itspace.angular_spring_backend.service;

import am.itspace.angular_spring_backend.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post createPost(Post post);

    Optional<Post> findById(Integer id);

    List<Post> findAll();

    Post editPostById(Integer postId, Post post);

    void deleteById(Integer id);
}
