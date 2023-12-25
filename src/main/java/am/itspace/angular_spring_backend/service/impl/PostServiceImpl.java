package am.itspace.angular_spring_backend.service.impl;

import am.itspace.angular_spring_backend.entity.Post;
import am.itspace.angular_spring_backend.repository.PostRepository;
import am.itspace.angular_spring_backend.service.ImageService;
import am.itspace.angular_spring_backend.service.PostService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final ImageService imageService;

    public PostServiceImpl(PostRepository postRepository,
                           @Lazy ImageService imageService) {
        this.postRepository = postRepository;
        this.imageService = imageService;
    }

    @Override
    public Post createPost(Post post) {
        post.setCreatedAt(LocalDateTime.now());
        return postRepository.save(post);
    }

    @Override
    public Optional<Post> findById(Integer id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post editPostById(Integer postId, Post post) {
        return postRepository.findById(postId)
                .map(currentPost -> {
                    currentPost.setTitle(post.getTitle());
                    currentPost.setPermalink(post.getPermalink());
                    currentPost.setContent(post.getContent());
                    currentPost.setExcerpt(post.getExcerpt());
                    if (post.getImageUrl() != null) {
                        currentPost.setImageUrl(post.getImageUrl());
                    }
                    currentPost.setCategory(post.getCategory());
                    return postRepository.save(currentPost);
                })
                .orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        imageService.deleteByPostId(id);
        postRepository.deleteById(id);

    }
}
