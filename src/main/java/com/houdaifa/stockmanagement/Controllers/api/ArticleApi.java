package com.houdaifa.stockmanagement.Controllers.api;

import com.houdaifa.stockmanagement.Dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.houdaifa.stockmanagement.utils.Constante.APP_ROOT;
public interface ArticleApi {
    @PostMapping(value = APP_ROOT+"/articles/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(@RequestBody  ArticleDto articleDto);
    @GetMapping(value = APP_ROOT+"/articles/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();
    @DeleteMapping(value = APP_ROOT+"/articles/delete/{idArticle}",consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable ("idArticle") Integer id);
    @GetMapping(value = APP_ROOT+"/articles/{idArticle}",params = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("idArticle") Integer id);
    @GetMapping(value = APP_ROOT+"/articles/{codeArticle}",params = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCode(@PathVariable("codeArticle") String code);
}
