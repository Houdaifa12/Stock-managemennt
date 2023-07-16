package com.houdaifa.stockmanagement.repository;

import com.houdaifa.stockmanagement.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Optional<Category> findByCodeCategory(String code);
}
