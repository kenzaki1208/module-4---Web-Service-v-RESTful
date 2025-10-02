package org.example.demowebserviceandrestful.exercise.repository;

import org.example.demowebserviceandrestful.exercise.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
