package com.houdaifa.stockmanagement.validators;

import com.houdaifa.stockmanagement.Dto.RolesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RolesValidator {
    public static List<String> validate(RolesDto rolesDto){
        List<String> errors=new ArrayList<>();
        if (rolesDto==null){
            errors.add("please enter the name of role");
            errors.add("please insert the user of this role");
            return errors;
        }
        if(!StringUtils.hasLength(rolesDto.getRoleName())){
            errors.add("please enter the name of the role");
        }
        return errors;
    }
}
