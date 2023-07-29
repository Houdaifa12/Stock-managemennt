package com.houdaifa.stockmanagement.Controllers;

import com.houdaifa.stockmanagement.Controllers.api.FournisseurApi;
import com.houdaifa.stockmanagement.Dto.FournisseurDto;
import com.houdaifa.stockmanagement.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class FournisseurController implements FournisseurApi {
    @Autowired
    private FournisseurService FournisseurService;

    @Override
    public FournisseurDto save(FournisseurDto FournisseurDto) {
        return FournisseurService.save(FournisseurDto);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return FournisseurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        FournisseurService.findAll();
    }

    @Override
    public FournisseurDto findById(Integer id) {
        return FournisseurService.findById(id);
    }

    @Override
    public FournisseurDto findByNomFournisseur(String nom) {
        return FournisseurService.findByNomFournisseur(nom);
    }
}
