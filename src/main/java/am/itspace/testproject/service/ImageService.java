package am.itspace.testproject.service;

import am.itspace.testproject.entity.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    Image saveImage(MultipartFile multipartFiles, Integer id);
}
