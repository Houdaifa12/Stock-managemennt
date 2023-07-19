package com.houdaifa.stockmanagement.validators;

import com.houdaifa.stockmanagement.Dto.LigneCommandeFournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeFournisseurValidator {

        public static List<String> validate(LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
            List<String> errors = new ArrayList<>();


            if (ligneCommandeFournisseurDto == null||ligneCommandeFournisseurDto.getQuantite() == null) {
                errors.add("please enter the quantity");

            }
            return errors;
        }




}
