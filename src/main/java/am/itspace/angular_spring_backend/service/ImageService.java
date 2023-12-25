package am.itspace.angular_spring_backend.service;

import am.itspace.angular_spring_backend.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface ImageService {
    Image saveImage(MultipartFile multipartFiles, Integer id);

    Optional<Image> findById(Integer postId);

    Optional<Image> findByPicUrl(String imageName);

    Optional<Image> findByPostId(Integer postId);

    void deleteByPostId(Integer postId);
}
