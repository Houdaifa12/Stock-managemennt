package com.houdaifa.stockmanagement.validators;

import com.houdaifa.stockmanagement.Dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {
    public static List<String> validate(ArticleDto articleDto){
        List<String>errors=new ArrayList<>();
        if(articleDto==null){
            errors.add("Please enter The code of the article");
            errors.add("Please enter The photo of the article");
            errors.add("Please enter The VAT rate of the article");
            errors.add("Please enter The unit Htc Price of the article");
            errors.add("Please enter The unit Price Ttc of the article");
            return errors;
        }
        if(!StringUtils.hasLength(articleDto.getCodeArticle()))
        {
            errors.add("Please enter The code of the article");
        }
        if(!StringUtils.hasLength(articleDto.getPhoto()))
        {
            errors.add("Please enter The photo of the article");
        }
        if(articleDto.getTauxTva()==null)
        {
            errors.add("Please enter The VAT rate of the article");
        }

        if(articleDto.getPrixUnitaireHt()==null)
        {
            errors.add("Please enter The unit Htc Price of the article");
        }
        if(articleDto.getPrixUnitaireTtc()==null)
        {
            errors.add("Please enter The unit Price Ttc of the article");
        }
        if(articleDto.getCategory()==null){
            errors.add("Please Select a category");
        }
        return errors;
    }
}
