package com.houdaifa.stockmanagement.Controllers.api;

import com.houdaifa.stockmanagement.Dto.EntrepriseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.houdaifa.stockmanagement.utils.Constante.APP_ROOT;

public interface EntrepriseApi {
    @PostMapping(value = APP_ROOT+"/entreprise/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto save(@RequestBody EntrepriseDto EntrepriseDto);
    @GetMapping(value = APP_ROOT+"/entreprise/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDto> findAll();
    @DeleteMapping(value = APP_ROOT+"/entreprise/delete/{idEntreprise}",consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idEntreprise") Integer id);
    @GetMapping(value = APP_ROOT+"/entreprise/{idEntreprise}",params = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);
    @GetMapping(value = APP_ROOT+"/entreprise/{nomEntreprise}",params = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findByCode(@PathVariable("nomEntreprise") String nom);
}
