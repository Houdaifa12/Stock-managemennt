package com.houdaifa.stockmanagement.services.impl;

import com.houdaifa.stockmanagement.Dto.VentesDto;
import com.houdaifa.stockmanagement.exceptions.EntityNotFoundException;
import com.houdaifa.stockmanagement.exceptions.ErrorCodes;
import com.houdaifa.stockmanagement.exceptions.InvalidEntityException;
import com.houdaifa.stockmanagement.model.Article;
import com.houdaifa.stockmanagement.model.Ventes;
import com.houdaifa.stockmanagement.repository.ArticleRepository;
import com.houdaifa.stockmanagement.repository.VentesRepository;
import com.houdaifa.stockmanagement.services.VentesService;
import com.houdaifa.stockmanagement.validators.VentesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VentesServicesImpl implements VentesService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private VentesRepository ventesRepository;
    @Override
    public VentesDto save(VentesDto ventesDto) {
        List<String>errors= VentesValidator.validate(ventesDto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("the purchases are invalid", ErrorCodes.VENTE_NOT_VALID,errors);
        }
        List<String>errors1=new ArrayList<>();
        ventesDto.getLigneVenteDtos().forEach((ligneVenteDto) ->
                {
                    Optional<Article> article=articleRepository.findById(ligneVenteDto.getArticleDto().getId());
                    if(article==null){
                        errors1.add("the article with the id: "+article.get().getId()+"is not existed in the DB");
                    }

                }


        );
        if(errors1.isEmpty()){
            log.error("one or more than one articles are not valid");
            throw new InvalidEntityException("One or more articles",ErrorCodes.VENTE_NOT_VALID,errors1);
        }
        return VentesDto.fromEntity(ventesRepository.save(VentesDto.toEntity(ventesDto)));
    }

    @Override
    public VentesDto findById(Integer id) {
        if(id==null){
            log.error("the given id is null");
        }
        Optional<Ventes>ventes=ventesRepository.findById(id);
        return VentesDto.fromEntity(Optional.of(ventes.get()).orElseThrow(()->
                 new EntityNotFoundException("the purchase with the id:"+id+"is not found", ErrorCodes.VENTE_NOT_FOUND)
                ));

    }

    @Override
    public void deleteById(Integer id) {
       if(id==null){
           log.error("the given id is null");
           return;
       }
       ventesRepository.deleteById(id);
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesRepository.findAll().stream().map(VentesDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public VentesDto findPurchaseByCode(String code) {
        if(code==null){
            log.error("the given id is null");
        }
        Optional<Ventes>ventes=ventesRepository.findByCode(code);
        return VentesDto.fromEntity(Optional.of(ventes.get()).orElseThrow(()->
                new EntityNotFoundException("the purchase with the code:"+code+"is not found", ErrorCodes.VENTE_NOT_FOUND)
        ));
    }
}
