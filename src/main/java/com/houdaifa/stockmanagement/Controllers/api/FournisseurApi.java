package com.houdaifa.stockmanagement.Controllers.api;

import com.houdaifa.stockmanagement.Dto.FournisseurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.houdaifa.stockmanagement.utils.Constante.APP_ROOT;

public interface FournisseurApi {
    @PostMapping(value = APP_ROOT+"/fournisseurs/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto save(@RequestBody FournisseurDto FournisseurDto);
    @GetMapping(value = APP_ROOT+"/fournisseurs/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDto> findAll();
    @DeleteMapping(value = APP_ROOT+"/fournisseurs/delete/{idFournisseur}",consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idFournisseur") Integer id);
    @GetMapping(value = APP_ROOT+"/fournisseurs/{idFournisseur}",params = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findById(@PathVariable("idFournisseur") Integer id);
    @GetMapping(value = APP_ROOT+"/fournisseurs/{nomFournisseur}",params = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findByNomFournisseur(@PathVariable("nomFournisseur") String nom);


}
