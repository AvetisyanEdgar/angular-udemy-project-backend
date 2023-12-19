package am.itspace.testproject.service.impl;

import am.itspace.testproject.entity.Category;
import am.itspace.testproject.repository.CategoryRepository;
import am.itspace.testproject.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Optional<Category> findById(Integer categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(@RequestBody Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public Category editCategory(Category updatedCategory) {
        Category currentCategory = categoryRepository.findById(updatedCategory.getId())
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + updatedCategory.getId()));

        currentCategory.setName(updatedCategory.getName());

        return categoryRepository.save(currentCategory);
    }
}
