package com.houdaifa.stockmanagement.validators;

import com.houdaifa.stockmanagement.Dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String> validate(UtilisateurDto utilisateurDto){
        List<String>errors=new ArrayList<>();
        if(utilisateurDto==null){
            errors.add("Please enter your FirstName");
            errors.add("Please enter your LastName");
            errors.add("Please enter your Password");
            errors.add("Please enter your address");
            errors.add("Please enter your Birth date");
            return errors;
        }
        if(!StringUtils.hasLength(utilisateurDto.getNom())){
            errors.add("Please enter your FirstName");
        }
        if(!StringUtils.hasLength(utilisateurDto.getPrenom())){
            errors.add("Please enter your LastName");
        }
        if(!StringUtils.hasLength(utilisateurDto.getMotDePasse())){
            errors.add("Please enter your Password");
        }
        if(utilisateurDto.getAdresse()==null){
            errors.add("Please enter your address");
        }else{
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())){
                errors.add("The field Address1 is mandatory");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse2())){
                errors.add("The field Address2 is mandatory");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())){
                errors.add("The field Country is mandatory");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())){
                errors.add("The field City is mandatory");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())){
                errors.add("The field ZIP Code is mandatory");
            }


        }
        if(utilisateurDto.getDateDeNaissance()==null){
            errors.add("Please enter your Birth date");
        }



        return errors;
    }
}
