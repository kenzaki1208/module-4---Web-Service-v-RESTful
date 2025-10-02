package org.example.demowebserviceandrestful.exercise.service;

import org.example.demowebserviceandrestful.exercise.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    Category save(Category category);
    void deleteById(Long id);
}
