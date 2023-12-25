package am.itspace.angular_spring_backend.controller;

import am.itspace.angular_spring_backend.entity.Image;
import am.itspace.angular_spring_backend.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/image")
public class ImageController {
    private final ImageService imageService;
    @Value("${image.folder.path}")
    private String imageFolder;

    @PostMapping("/{post-id}")
    public Image saveImage(@RequestParam("file") MultipartFile multipartFile, @PathVariable("post-id") Integer postId) {
        return imageService.saveImage(multipartFile, postId);
    }

    @GetMapping("/{imageName}")
    public ResponseEntity<byte[]> getImageByName(@PathVariable String imageName) throws IOException {
        Optional<Image> image = imageService.findByPicUrl(imageName);

        if (image.isPresent()) {
            Image currentImage = image.get();
            Path imagePath = Paths.get(imageFolder, currentImage.getPicUrl());
            Resource resource = new UrlResource(imagePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                byte[] imageBytes = resource.getInputStream().readAllBytes();

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.IMAGE_PNG);

                return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
