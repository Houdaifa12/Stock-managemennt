package com.houdaifa.stockmanagement.services.impl;

import com.houdaifa.stockmanagement.Dto.EntrepriseDto;
import com.houdaifa.stockmanagement.exceptions.EntityNotFoundException;
import com.houdaifa.stockmanagement.exceptions.ErrorCodes;
import com.houdaifa.stockmanagement.exceptions.InvalidEntityException;
import com.houdaifa.stockmanagement.model.Entreprise;
import com.houdaifa.stockmanagement.repository.EntrepriseRepository;
import com.houdaifa.stockmanagement.services.EntrepriseService;
import com.houdaifa.stockmanagement.validators.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {
    @Autowired
    private EntrepriseRepository entrepriseRepository;
    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        List<String>errors= EntrepriseValidator.validate(entrepriseDto);
        if(!errors.isEmpty()){
            log.error("client Not valid ",entrepriseDto);
            throw new InvalidEntityException("The given company is not valid", ErrorCodes.CLIENT_NOT_VALID,errors);
        }

        return entrepriseDto.fromEntity(entrepriseRepository.save(entrepriseDto.toEntity(entrepriseDto)));
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if(id==null){
            log.error("the given id is null");
            return null;
        }
        Optional<Entreprise> entreprise=entrepriseRepository.findById(id);
        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(()->
                new EntityNotFoundException("The Comapany with the id:"+id+"is not existed", ErrorCodes.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public EntrepriseDto findByNomEntreprise(String nom) {
        if (nom==null){
            log.error("the given code is nom");
            return null;
        }
        Optional<Entreprise>entreprise=entrepriseRepository.findByNom(nom);
        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(()->

                new EntityNotFoundException("The Company with the nom:"+nom+"is not existed", ErrorCodes.CLIENT_NOT_FOUND)
        );
    }

    @Override
    public void deleteById(Integer id) {
        if(id==null){
            log.error("the given id is null");
            return;
        }
        entrepriseRepository.deleteById(id);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll()
                .stream().map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }
}
