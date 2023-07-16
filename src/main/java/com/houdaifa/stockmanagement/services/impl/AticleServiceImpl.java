package com.houdaifa.stockmanagement.services.impl;

import com.houdaifa.stockmanagement.Dto.ArticleDto;
import com.houdaifa.stockmanagement.exceptions.EntityNotFoundException;
import com.houdaifa.stockmanagement.exceptions.ErrorCodes;
import com.houdaifa.stockmanagement.exceptions.InvalidEntityException;
import com.houdaifa.stockmanagement.model.Article;
import com.houdaifa.stockmanagement.repository.ArticleRepository;
import com.houdaifa.stockmanagement.services.ArticleService;
import com.houdaifa.stockmanagement.validators.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String>errors= ArticleValidator.validate(articleDto);
        if(!errors.isEmpty()){
            log.error("article is not valid()",articleDto);
            throw new InvalidEntityException("the article is not valid", ErrorCodes.ARTICLE_NOT_VALID,errors);
        }
        return articleDto.fromEntity(articleRepository.save(articleDto.toEntity(articleDto)));

    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll()
                .stream().map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
      if (id==null){
          log.error("The given id is null");
          return;
      }
     articleRepository.deleteById(id);

    }

    @Override
    public ArticleDto findById(Integer id) {
        if(id==null) {
            log.error("Article id is null");
            return null;
        }
        Optional<Article> article=articleRepository.findById(id);
        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()->
        new EntityNotFoundException(
           "NO Article with ID= "+id+ "IS existed",ErrorCodes.ARTICLE_NOT_FOUND)

        );



    }

    @Override
    public ArticleDto findByCode(String code) {
        if(code==null) {
            log.error("Article id is null");
            return null;
        }
        Optional<Article> article=articleRepository.findArticleByCodeArticle(code);
        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "NO Article with CODE= "+code+ "IS existed",ErrorCodes.ARTICLE_NOT_FOUND)

        );
    }
}
