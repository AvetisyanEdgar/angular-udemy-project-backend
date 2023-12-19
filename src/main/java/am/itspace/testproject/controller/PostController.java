package am.itspace.testproject.controller;

import am.itspace.testproject.entity.Post;
import am.itspace.testproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping()
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }
}
