package com.houdaifa.stockmanagement.validators;

import com.houdaifa.stockmanagement.Dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public static List<String>validate(ClientDto clientDto){
        List<String>errors=new ArrayList<>();
        if(clientDto==null){
            errors.add("Please enter the FirstName");
            errors.add("Please enter the LastName");
            errors.add("Please enter the Mail");
            errors.add("Please enter the Phone Number");
            errors.add("Please enter Address");
            return errors;
        }
        if(!StringUtils.hasLength(clientDto.getNom())){
            errors.add("Please enter the FirstName");
        }
        if(!StringUtils.hasLength(clientDto.getPrenom())){
            errors.add("Please enter the LastName");
        }
        if(!StringUtils.hasLength(clientDto.getMail())){
            errors.add("Please enter the Mail");
        }
        if(!StringUtils.hasLength(clientDto.getNumTel())){
            errors.add("Please enter the Phone Number");
        }
        if(clientDto.getAdresse()==null){
            errors.add("Please enter Address");
        }else {
            if (!StringUtils.hasLength(clientDto.getAdresse().getAdresse1())) {
                errors.add("The field Address1 is mandatory");
            }
            if (!StringUtils.hasLength(clientDto.getAdresse().getAdresse2())) {
                errors.add("The field Address2 is mandatory");
            }
            if (!StringUtils.hasLength(clientDto.getAdresse().getPays())) {
                errors.add("The field Country is mandatory");
            }
            if (!StringUtils.hasLength(clientDto.getAdresse().getVille())) {
                errors.add("The field City is mandatory");
            }
            if (!StringUtils.hasLength(clientDto.getAdresse().getCodePostale())) {
                errors.add("The field ZIP Code is mandatory");
            }
        }
        return errors;
    }
}
