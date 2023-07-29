package com.houdaifa.stockmanagement.Controllers;

import com.houdaifa.stockmanagement.Controllers.api.ArticleApi;
import com.houdaifa.stockmanagement.Controllers.api.UtilisateurApi;
import com.houdaifa.stockmanagement.Dto.ArticleDto;
import com.houdaifa.stockmanagement.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import static com.houdaifa.stockmanagement.utils.Constante.APP_ROOT;
@RestController
@RequestMapping(value=APP_ROOT+"/articles")
public class ArticleController implements ArticleApi {
    @Autowired
    private ArticleService articleService;

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        return articleService.save(articleDto);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Integer id) {
    articleService.findAll();
    }

    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByCode(String code) {
        return articleService.findByCode(code);
    }
}
