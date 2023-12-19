package am.itspace.testproject.service.impl;

import am.itspace.testproject.entity.Post;
import am.itspace.testproject.repository.PostRepository;
import am.itspace.testproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Optional<Post> findById(Integer id) {
        return postRepository.findById(id);
    }
}
