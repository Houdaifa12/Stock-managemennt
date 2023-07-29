package com.houdaifa.stockmanagement.Controllers.api;

import com.houdaifa.stockmanagement.Dto.ArticleDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import io.swagger.v3.oas.models.annotations.OpenAPI31;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.houdaifa.stockmanagement.utils.Constante.APP_ROOT;

public interface ArticleApi {
    @PostMapping(value = APP_ROOT+"/articles/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "save an article (create)/(modify) ",description = "this method enable you to create or update an article")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "article created/modified"),
                    @ApiResponse (responseCode = "400",description = "the article is not valid")

            }

    )
    ArticleDto save(@RequestBody  ArticleDto articleDto);
    @GetMapping(value = APP_ROOT+"/articles/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "find all articles (findAll) ",description = "this method enable you to get or all existing artciles")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "all articles")
             ,      @ApiResponse (responseCode = "400",description = "")

            }
    )
    List<ArticleDto> findAll();
    @DeleteMapping(value = APP_ROOT+"/articles/delete/{idArticle}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "delete an article (remove) ",description = "this method enable you to remove an article")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "article deleted successfully"),
                    @ApiResponse(responseCode = "400",description = "failed deletion operation")
            }
    )
    void delete(@PathVariable ("idArticle") Integer id);
    @GetMapping(value = APP_ROOT+"/articles/{idArticle}",params = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "find an  article (by giving id) ",description = "this method enable you to retrieve an article by id if it's existed in DB")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "article found"),
                    @ApiResponse (responseCode = "400",description = "no article existed in database with this id")

            }
    )
    ArticleDto findById(@PathVariable("idArticle") Integer id);
    @GetMapping(value = APP_ROOT+"/articles/{codeArticle}",params = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "find an  article (by giving code) ",description = "this method enable you to retrieve an article by code if it's existed in DB")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "article found"),
                    @ApiResponse (responseCode = "400",description = "no article existed in database with the given code")

            }
    )
    ArticleDto findByCode(@PathVariable("codeArticle") String code);
}
