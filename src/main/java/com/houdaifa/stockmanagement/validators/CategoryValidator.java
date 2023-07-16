package com.houdaifa.stockmanagement.validators;

import com.houdaifa.stockmanagement.Dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {
    public static List<String> validate(CategoryDto categoryDto){
        List<String>errors=new ArrayList<>();
        if(categoryDto==null||!StringUtils.hasLength(categoryDto.getCode())){
            errors.add("please enter the category code");
        }
        return errors;
    }
}
