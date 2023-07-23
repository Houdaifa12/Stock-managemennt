package com.houdaifa.stockmanagement.Dto;

import com.houdaifa.stockmanagement.model.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDto {
    private Integer id;
    private String codeArticle;
    private String designation;
    private BigDecimal tauxTva;
    private BigDecimal prixUnitaireHt;
    private BigDecimal prixUnitaireTtc;
    private String photo;
    private CategoryDto category;
    private Integer quantity;
    public static ArticleDto fromEntity(Article article) {
        if (article == null) {
            return null;
        } else {
            ArticleDto articleDto=new ArticleDto();
            articleDto.setCodeArticle(article.getCodeArticle());
            articleDto.setPhoto(article.getPhoto());
            articleDto.setQuantity(articleDto.getQuantity());
            articleDto.setDesignation(article.getDesignation());
            articleDto.setPrixUnitaireTtc(article.getPrixUnitaireTtc());
            articleDto.setPrixUnitaireHt(article.getPrixUnitaireHt());
            articleDto.setTauxTva(article.getTauxTva());
            articleDto.category.fromEntity(article.getCategory());
            return articleDto;

        }
    }
    public static Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            return null;
        } else {
            Article article=new Article();
            article.setQuantity(articleDto.getQuantity());
            article.setCodeArticle(articleDto.getCodeArticle());
            article.setPhoto(articleDto.getPhoto());
            article.setDesignation(articleDto.getDesignation());
            article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
            article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
            article.setTauxTva(articleDto.getTauxTva());
            return article;


        }
    }
}
