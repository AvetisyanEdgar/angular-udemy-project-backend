package am.itspace.testproject.service.impl;

import am.itspace.testproject.entity.Image;
import am.itspace.testproject.entity.Post;
import am.itspace.testproject.repository.ImageRepository;
import am.itspace.testproject.service.ImageService;
import am.itspace.testproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final PostService postService;
    @Value("${image.folder.path}")
    private String FOLDER_PATH;

    public Image saveImage(MultipartFile file, Integer id) {
        try {
            Post post = new Post();
            Optional<Post> byId = postService.findById(id);
            if (byId.isPresent()) {
                post = byId.get();
                if (!file.isEmpty() && file.getSize() > 0) {
                    String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                    File newFile = new File(FOLDER_PATH + File.separator + fileName);
                    file.transferTo(newFile);
                    post.setImageUrl(fileName);
                    Image postImage = Image.builder().post(post).picUrl(fileName).build();
                    imageRepository.save(postImage);
                    return postImage;
                }
            } else {
                post.setImageUrl(FOLDER_PATH);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }
}
