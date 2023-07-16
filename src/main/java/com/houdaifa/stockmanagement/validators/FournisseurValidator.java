package com.houdaifa.stockmanagement.validators;

import com.houdaifa.stockmanagement.Dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {
    public static List<String> validate(FournisseurDto fournisseurDto){
        List<String>errors=new ArrayList<>();
        if(fournisseurDto==null){
            errors.add("Please enter the FirstName");
            errors.add("Please enter the LastName");
            errors.add("Please enter the Mail");
            errors.add("Please enter the Phone Number");
            errors.add("Please enter Address");
            return errors;
        }
        if(!StringUtils.hasLength(fournisseurDto.getNom())){
            errors.add("Please enter the FirstName");
        }
        if(!StringUtils.hasLength(fournisseurDto.getPrenom())){
            errors.add("Please enter the LastName");
        }
        if(!StringUtils.hasLength(fournisseurDto.getMail())){
            errors.add("Please enter the Mail");
        }
        if(!StringUtils.hasLength(fournisseurDto.getNumTel())){
            errors.add("Please enter the Phone Number");
        }
        if(fournisseurDto.getAddress()==null){
            errors.add("Please enter Address");
        }else {
            if (!StringUtils.hasLength(fournisseurDto.getAddress().getAdresse1())) {
                errors.add("The field Address1 is mandatory");
            }
            if (!StringUtils.hasLength(fournisseurDto.getAddress().getAdresse2())) {
                errors.add("The field Address2 is mandatory");
            }
            if (!StringUtils.hasLength(fournisseurDto.getAddress().getPays())) {
                errors.add("The field Country is mandatory");
            }
            if (!StringUtils.hasLength(fournisseurDto.getAddress().getVille())) {
                errors.add("The field City is mandatory");
            }
            if (!StringUtils.hasLength(fournisseurDto.getAddress().getCodePostale())) {
                errors.add("The field ZIP Code is mandatory");
            }
        }
        return errors;
    }
}
