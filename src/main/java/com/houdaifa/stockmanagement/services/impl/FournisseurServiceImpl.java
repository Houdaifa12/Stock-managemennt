package com.houdaifa.stockmanagement.services.impl;

import com.houdaifa.stockmanagement.Dto.EntrepriseDto;
import com.houdaifa.stockmanagement.Dto.FournisseurDto;
import com.houdaifa.stockmanagement.exceptions.EntityNotFoundException;
import com.houdaifa.stockmanagement.exceptions.ErrorCodes;
import com.houdaifa.stockmanagement.exceptions.InvalidEntityException;
import com.houdaifa.stockmanagement.model.Entreprise;
import com.houdaifa.stockmanagement.model.Fournisseur;
import com.houdaifa.stockmanagement.repository.FournisseurRepository;
import com.houdaifa.stockmanagement.services.FournisseurService;
import com.houdaifa.stockmanagement.validators.ClientValidator;
import com.houdaifa.stockmanagement.validators.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {
    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        List<String>errors= FournisseurValidator.validate(fournisseurDto);
        if(!errors.isEmpty()){
            log.error("Supplier Not valid ",fournisseurDto);
            throw new InvalidEntityException("The given supplier is not valid", ErrorCodes.CLIENT_NOT_VALID,errors);
        }

        return fournisseurDto.fromEntity(fournisseurRepository.save(fournisseurDto.toEntity(fournisseurDto)));
    }

    @Override
    public FournisseurDto findById(Integer id) {
        if(id==null){
            log.error("the given id is null");
            return null;
        }
        Optional<Fournisseur> fournisseur=fournisseurRepository.findById(id);
        return Optional.of(FournisseurDto.fromEntity(fournisseur.get())).orElseThrow(()->
                new EntityNotFoundException("The Supplier with the id:"+id+"is not existed", ErrorCodes.FOURNISSEUR_NOT_FOUND)
        );

    }

    @Override
    public FournisseurDto findByNomFournisseur(String nom) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        if(id==null){
            log.error("the given id is null");
            return;
        }
        fournisseurRepository.deleteById(id);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll()
                .stream().map(FournisseurDto::fromEntity)
                .collect(Collectors.toList());

    }
}
