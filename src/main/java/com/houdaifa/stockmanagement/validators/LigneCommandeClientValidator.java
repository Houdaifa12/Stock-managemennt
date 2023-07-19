package com.houdaifa.stockmanagement.validators;

import com.houdaifa.stockmanagement.Dto.LigneCommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {
    public static List<String>validate(LigneCommandeClientDto ligneCommandeClientDto) {
        List<String> errors = new ArrayList<>();


        if (ligneCommandeClientDto == null||ligneCommandeClientDto.getQuantite() == null) {
            errors.add("please enter the quantity");

        }
        return errors;
    }


}
