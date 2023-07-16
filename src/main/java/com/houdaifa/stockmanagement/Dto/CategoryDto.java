package com.houdaifa.stockmanagement.Dto;

import com.houdaifa.stockmanagement.model.Article;
import com.houdaifa.stockmanagement.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    private Integer id;
    private String code;
    private String designation;
    private List<ArticleDto> articles;

    public static CategoryDto fromEntity(Category category) {
        if (category==null){
            return null;
        }
        CategoryDto categoryDto=new CategoryDto();
        categoryDto.setId(category.getId());
        List<ArticleDto>articleDtos=new ArrayList<>();
        for(Article article:category.getArticles()){
            ArticleDto articleDto=new ArticleDto();
            articleDto.fromEntity(article);
            articleDtos.add(articleDto);

        }
        categoryDto.setArticles(articleDtos);
        categoryDto.setCode(category.getCodeCategory());
        categoryDto.setDesignation(category.getDesignation());
        return categoryDto;
    }



    public static Category toEntity(CategoryDto categoryDto){
        if (categoryDto==null){
            return null;
        }
       else {
            Category category = new Category();
            category.setId(categoryDto.getId());
            category.setCodeCategory(categoryDto.getCode());
            List<Article>articles=new ArrayList<>();
            for(ArticleDto articleDto:categoryDto.getArticles()){
                Article article=new Article();
                article=articleDto.toEntity(articleDto);
                articles.add(article);
            }
            category.setArticles(articles);
            category.setDesignation(categoryDto.getDesignation());
            return category;
        }
    }



}