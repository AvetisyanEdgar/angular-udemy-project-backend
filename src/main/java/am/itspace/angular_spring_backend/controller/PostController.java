package am.itspace.angular_spring_backend.controller;

import am.itspace.angular_spring_backend.entity.Post;
import am.itspace.angular_spring_backend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping()
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @GetMapping()
    public List<Post> findAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Post> findPostById(@PathVariable(name = "id") Integer postId) {
        return postService.findById(postId);
    }

    @PatchMapping("/{id}")
    public Post editPostById(@PathVariable("id") Integer postId, @RequestBody Post post) {
        return postService.editPostById(postId, post);
    }

    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable("id") Integer postId) {
        postService.deleteById(postId);
    }
}
