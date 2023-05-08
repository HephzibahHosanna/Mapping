package com.example.Mapping.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Mapping.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {

	Optional<Category> findByName(String name);

}
