package com.houdaifa.stockmanagement.Controllers.api;

import com.houdaifa.stockmanagement.Dto.UtilisateurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.houdaifa.stockmanagement.utils.Constante.APP_ROOT;

public interface UtilisateurApi {
    @PostMapping(value = APP_ROOT+"/Utilisateurs/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto save(@RequestBody UtilisateurDto UtilisateurDto);
    @GetMapping(value = APP_ROOT+"/Utilisateurs/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<UtilisateurDto> findAll();
    @DeleteMapping(value = APP_ROOT+"/Utilisateurs/delete/{idUtilisateur}",consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idUtilisateur") Integer id);
    @GetMapping(value = APP_ROOT+"/Utilisateurs/{idUtilisateur}",params = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);
    
}
