package com.houdaifa.stockmanagement.services.impl;

import com.houdaifa.stockmanagement.Dto.CategoryDto;
import com.houdaifa.stockmanagement.exceptions.EntityNotFoundException;
import com.houdaifa.stockmanagement.exceptions.ErrorCodes;
import com.houdaifa.stockmanagement.exceptions.InvalidEntityException;
import com.houdaifa.stockmanagement.model.Category;
import com.houdaifa.stockmanagement.repository.CategoryRepository;
import com.houdaifa.stockmanagement.services.CategoryService;
import com.houdaifa.stockmanagement.validators.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String>errors=CategoryValidator.validate(categoryDto);
        if(!errors.isEmpty()){
            log.error("Category Not valid ",categoryDto);
            throw new InvalidEntityException("The given Category is not valid", ErrorCodes.CATEGORY_NOT_VALID,errors);
        }

        return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(categoryDto)));
    }

    @Override
    public CategoryDto findById(Integer id) {
        if(id==null){
            log.error("the given id is null");
            return null;
        }
        Optional<Category> category=categoryRepository.findById(id);
        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(()->
                new EntityNotFoundException("The Category with the id:"+id+"is not existed", ErrorCodes.CATEGORY_NOT_FOUND)
                );
    }

    @Override
    public CategoryDto findByCodeCategory(String code) {
       if (code==null){
           log.error("the given code is null");
           return null;
       }
       Optional<Category>category=categoryRepository.findByCodeCategory(code);
       return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(()->

          new EntityNotFoundException("The Category with the code:"+code+"is not existed", ErrorCodes.CATEGORY_NOT_FOUND)
       );
    }

    @Override
    public void deleteById(Integer id) {
        if(id==null){
            log.error("the given id is null");
            return;
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryDto:: fromEntity)
                .collect(Collectors.toList());
    }
}
