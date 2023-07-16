package com.houdaifa.stockmanagement.Controllers.api;

import com.houdaifa.stockmanagement.Dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.houdaifa.stockmanagement.utils.Constante.APP_ROOT;

public interface CategoryApi {
    @PostMapping(value = APP_ROOT+"/categories/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(@RequestBody CategoryDto categoryDto);
    @GetMapping(value = APP_ROOT+"/categories/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();
    @DeleteMapping(value = APP_ROOT+"/categories/delete/{idCategory}",consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idACategory") Integer id);
    @GetMapping(value = APP_ROOT+"/categories/{idACategory}",params = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable("idCategory") Integer id);
    @GetMapping(value = APP_ROOT+"/categories/{codeCategory}",params = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCode(@PathVariable("codeCategory") String code);
}
