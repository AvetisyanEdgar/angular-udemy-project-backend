package am.itspace.testproject.controller;

import am.itspace.testproject.entity.Category;
import am.itspace.testproject.service.CategoryService;
import am.itspace.testproject.service.ImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping()
    public Category addCategory(@Valid @RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping("/{categoryId}")
    public Optional<Category> findCategoryById(@PathVariable Integer categoryId) {
        return categoryService.findById(categoryId);
    }

    @GetMapping("/list")
    public List<Category> findAllCategories() {
        return categoryService.findAll();
    }

    @DeleteMapping()
    public void deleteCategory(@RequestBody Category category) {
        categoryService.deleteCategory(category);
    }

    @PatchMapping()
    public Category editCategoryById(@RequestBody Category category) {
        return categoryService.editCategory(category);
    }
}
