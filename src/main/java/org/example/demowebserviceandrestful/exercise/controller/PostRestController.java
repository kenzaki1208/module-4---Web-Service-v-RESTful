package org.example.demowebserviceandrestful.exercise.controller;

import org.example.demowebserviceandrestful.exercise.model.Post;
import org.example.demowebserviceandrestful.exercise.service.IPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostRestController {
    private final IPostService iPostService;

    public PostRestController(IPostService iPostService) {
        this.iPostService = iPostService;
    }

    @GetMapping("")
    public List<Post> getAllPosts() {
        return iPostService.findAll();
    }

    @GetMapping("/category/{categoryId}")
    public List<Post> getPostsByCategoryId(@PathVariable("categoryId") Long categoryId) {
        return iPostService.findByCategoryId(categoryId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Long id) {
        return iPostService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post saved = iPostService.save(post);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") Long id, @RequestBody Post updatedPost) {
        return iPostService.findById(id).map(post -> {
            post.setTitle(updatedPost.getTitle());
            post.setContent(updatedPost.getContent());
            post.setCategory(updatedPost.getCategory());
            Post saved = iPostService.save(post);
            return ResponseEntity.ok(saved);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Long id) {
        if (iPostService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        iPostService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}