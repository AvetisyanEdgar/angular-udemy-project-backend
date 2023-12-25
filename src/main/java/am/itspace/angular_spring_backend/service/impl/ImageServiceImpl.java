package am.itspace.angular_spring_backend.service.impl;

import am.itspace.angular_spring_backend.entity.Image;
import am.itspace.angular_spring_backend.entity.Post;
import am.itspace.angular_spring_backend.repository.ImageRepository;
import am.itspace.angular_spring_backend.service.ImageService;
import am.itspace.angular_spring_backend.service.PostService;
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

    @Override
    public Optional<Image> findById(Integer postId) {
        return imageRepository.findById(postId);
    }

    @Override
    public Optional<Image> findByPicUrl(String imageName) {
        return imageRepository.findByPicUrl(imageName);
    }

    @Override
    public Optional<Image> findByPostId(Integer postId) {
        return imageRepository.findByPostId(postId);
    }

    @Override
    public void deleteByPostId(Integer postId) {
        Optional<Image> byId = imageRepository.findByPostId(postId);
        byId.ifPresent(imageRepository::delete);
    }
}
