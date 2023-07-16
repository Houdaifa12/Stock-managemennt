package com.houdaifa.stockmanagement.services;

import com.houdaifa.stockmanagement.Dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    CategoryDto save(CategoryDto categoryDto);
    CategoryDto findById(Integer id);
    CategoryDto findByCodeCategory(String code);
    void deleteById(Integer id);
    List<CategoryDto>findAll();


}
