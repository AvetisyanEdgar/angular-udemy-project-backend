package am.itspace.angular_spring_backend.repository;

import am.itspace.angular_spring_backend.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    Optional<Image> findByPicUrl(String imageName);
    Optional<Image> findByPostId(Integer postId);
}
