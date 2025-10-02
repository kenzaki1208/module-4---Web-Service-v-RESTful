package org.example.demowebserviceandrestful.exercise.service;

import org.example.demowebserviceandrestful.exercise.model.Post;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    List<Post> findAll();
    List<Post> findByCategoryId(Long categoryId);
    Optional<Post> findById(Long id);
    Post save(Post post);
    void deleteById(Long id);
}
