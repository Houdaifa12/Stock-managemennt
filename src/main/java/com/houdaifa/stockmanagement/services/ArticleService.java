package com.houdaifa.stockmanagement.services;

import com.houdaifa.stockmanagement.Dto.ArticleDto;

import java.util.List;

public interface ArticleService {
    ArticleDto save(ArticleDto articleDto);
    List<ArticleDto>findAll();
    void delete(Integer id);
    ArticleDto findById(Integer id);
    ArticleDto findByCode(String code);
}
