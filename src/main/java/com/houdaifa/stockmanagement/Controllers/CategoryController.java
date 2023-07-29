package com.houdaifa.stockmanagement.Controllers;

import com.houdaifa.stockmanagement.Controllers.api.CategoryApi;
import com.houdaifa.stockmanagement.Dto.CategoryDto;
import com.houdaifa.stockmanagement.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CategoryController implements CategoryApi {
    @Autowired
    private CategoryService categoryService;

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void delete(Integer id) {
        categoryService.findAll();
    }

    @Override
    public CategoryDto findById(Integer id) {
        return categoryService.findById(id);
    }

    @Override
    public CategoryDto findByCode(String code) {
        return categoryService.findByCodeCategory(code);
    }

}
