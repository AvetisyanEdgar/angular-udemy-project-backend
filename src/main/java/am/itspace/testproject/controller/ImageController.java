package am.itspace.testproject.controller;

import am.itspace.testproject.entity.Image;
import am.itspace.testproject.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/image")
public class ImageController {
    private final ImageService imageService;

    @PostMapping(value = "/{post-id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Image saveImage(@RequestParam("file") MultipartFile multipartFile, @PathVariable("post-id") Integer postId) {
        return imageService.saveImage(multipartFile, postId);
    }
}
