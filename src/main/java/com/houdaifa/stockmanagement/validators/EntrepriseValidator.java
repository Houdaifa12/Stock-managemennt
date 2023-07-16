package com.houdaifa.stockmanagement.validators;

import com.houdaifa.stockmanagement.Dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {
    public static List<String> validate(EntrepriseDto entrepriseDto){
        List<String>errors=new ArrayList<>();
        if(entrepriseDto==null){
            errors.add("Please enter the FirstName");
            errors.add("Please enter the LastName");
            errors.add("Please enter the Mail");
            errors.add("Please enter the Phone Number");
            errors.add("Please enter Address");
            return errors;
        }
        if(!StringUtils.hasLength(entrepriseDto.getNom())){
            errors.add("Please enter the FirstName");
        }
        if(!StringUtils.hasLength(entrepriseDto.getCodeFiscal())){
            errors.add("Please enter the CodeFiscal");
        }

        if(!StringUtils.hasLength(entrepriseDto.getEmail())){
            errors.add("Please enter the Mail");
        }
        if(!StringUtils.hasLength(entrepriseDto.getNumTel())){
            errors.add("Please enter the Phone Number");
        }
        if(entrepriseDto.getAddress()==null){
            errors.add("Please enter Address");
        }else {
            if (!StringUtils.hasLength(entrepriseDto.getAddress().getAdresse1())) {
                errors.add("The field Address1 is mandatory");
            }
            if (!StringUtils.hasLength(entrepriseDto.getAddress().getAdresse2())) {
                errors.add("The field Address2 is mandatory");
            }
            if (!StringUtils.hasLength(entrepriseDto.getAddress().getPays())) {
                errors.add("The field Country is mandatory");
            }
            if (!StringUtils.hasLength(entrepriseDto.getAddress().getVille())) {
                errors.add("The field City is mandatory");
            }
            if (!StringUtils.hasLength(entrepriseDto.getAddress().getCodePostale())) {
                errors.add("The field ZIP Code is mandatory");
            }
        }
        return errors;
    }
}
