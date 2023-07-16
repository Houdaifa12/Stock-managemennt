package com.houdaifa.stockmanagement.services.impl;

import com.houdaifa.stockmanagement.Dto.ClientDto;
import com.houdaifa.stockmanagement.exceptions.EntityNotFoundException;
import com.houdaifa.stockmanagement.exceptions.ErrorCodes;
import com.houdaifa.stockmanagement.exceptions.InvalidEntityException;
import com.houdaifa.stockmanagement.model.Client;
import com.houdaifa.stockmanagement.repository.ClientRepository;
import com.houdaifa.stockmanagement.services.ClientService;
import com.houdaifa.stockmanagement.validators.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public ClientDto save(ClientDto clientDto) {
        List<String>errors= ClientValidator.validate(clientDto);
        if(!errors.isEmpty()){
            log.error("client Not valid ",clientDto);
            throw new InvalidEntityException("The given client is not valid", ErrorCodes.CLIENT_NOT_VALID,errors);
        }

        return clientDto.fromEntity(clientRepository.save(clientDto.toEntity(clientDto)));
    }

    @Override
    public ClientDto findById(Integer id) {
        if(id==null){
            log.error("the given id is null");
            return null;
        }
        Optional<Client>client=clientRepository.findById(id);
        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(()->
                new EntityNotFoundException("The Client with the id:"+id+"is not existed", ErrorCodes.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public ClientDto findByNomClient(String nom) {
        if (nom==null){
            log.error("the given code is nom");
            return null;
        }
        Optional<Client>client=clientRepository.findByNom(nom);
        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(()->

                new EntityNotFoundException("The Category with the nom:"+nom+"is not existed", ErrorCodes.CLIENT_NOT_FOUND)
        );
    }

    @Override
    public void deleteById(Integer id) {
      if(id==null){
          log.error("the given id is null");
          return;
      }
      clientRepository.deleteById(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }
}
