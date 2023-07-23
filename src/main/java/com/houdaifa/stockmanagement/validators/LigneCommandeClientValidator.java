package com.houdaifa.stockmanagement.validators;

import com.houdaifa.stockmanagement.Dto.LigneCommandeClientDto;
import com.houdaifa.stockmanagement.repository.ArticleRepository;
import com.houdaifa.stockmanagement.repository.LigneCommandeClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LigneCommandeClientValidator {
     @Autowired
     private static ArticleRepository articleRepository;
    public static List<String> validate(LigneCommandeClientDto ligneCommandeClientDto) {
        List<String> errors = new ArrayList<>();


        if (ligneCommandeClientDto.getQuantity() == null) {
            errors.add("please enter the quantity");
        }
        if (ligneCommandeClientDto.getArticle().getQuantity() < ligneCommandeClientDto.getQuantity()) {
            errors.add("we have just the quantity: "+ligneCommandeClientDto.getArticle().getQuantity());
        }
        if(articleRepository.findArticleByCodeArticle(ligneCommandeClientDto.getArticle().getCodeArticle())==null){
            errors.add("the article with the code :"+ligneCommandeClientDto.getArticle().getCodeArticle()+"is not found");
        }
        return errors;

    }
}