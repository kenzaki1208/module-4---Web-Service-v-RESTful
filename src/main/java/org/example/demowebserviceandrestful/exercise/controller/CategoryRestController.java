package org.example.demowebserviceandrestful.exercise.controller;

import org.example.demowebserviceandrestful.exercise.model.Category;
import org.example.demowebserviceandrestful.exercise.service.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
    private final ICategoryService iCategoryService;

    public CategoryRestController(ICategoryService iCategoryService) {
        this.iCategoryService = iCategoryService;
    }

    @GetMapping("")
    public List<Category> getAllCategories() {
        return iCategoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") Long id) {
        return iCategoryService.findById(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category saved = iCategoryService.save(category);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody Category updatedCategory) {
        return iCategoryService.findById(id).map(category -> {
            category.setName(updatedCategory.getName());
            Category saved = iCategoryService.save(category);
            return ResponseEntity.ok(saved);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
        if (iCategoryService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        iCategoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
