package am.itspace.angular_spring_backend.service;

import am.itspace.angular_spring_backend.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category saveCategory(Category category);

    Optional<Category> findById(Integer categoryId);

    List<Category> findAll();

    void deleteCategory(Category category);

    Category editCategory(Category category);
}
