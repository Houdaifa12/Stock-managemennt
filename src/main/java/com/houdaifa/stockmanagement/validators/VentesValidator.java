package com.houdaifa.stockmanagement.validators;

import com.houdaifa.stockmanagement.Dto.VentesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VentesValidator {
    private static List<String>errors=new ArrayList<>();
    public static List<String>validate(VentesDto ventesDto){
     if(!StringUtils.hasLength(ventesDto.getCode())){
         errors.add("please enter the code");
     }
     return errors;
    }
}
