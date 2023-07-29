package com.houdaifa.stockmanagement.Controllers;

import com.houdaifa.stockmanagement.Controllers.api.EntrepriseApi;
import com.houdaifa.stockmanagement.Dto.EntrepriseDto;
import com.houdaifa.stockmanagement.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class EntrepriseController implements EntrepriseApi {
    @Autowired
    private EntrepriseService entrepriseService;

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        return entrepriseService.save(entrepriseDto);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void delete(Integer id) {
        entrepriseService.findAll();
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        return entrepriseService.findById(id);
    }

    @Override
    public EntrepriseDto findByCode(String nom) {
        return entrepriseService.findByNomEntreprise(nom);
    }
}
