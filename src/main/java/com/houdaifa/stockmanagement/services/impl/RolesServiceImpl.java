package com.houdaifa.stockmanagement.services.impl;

import com.houdaifa.stockmanagement.Dto.RolesDto;
import com.houdaifa.stockmanagement.exceptions.EntityNotFoundException;
import com.houdaifa.stockmanagement.exceptions.ErrorCodes;
import com.houdaifa.stockmanagement.exceptions.InvalidEntityException;
import com.houdaifa.stockmanagement.model.Roles;
import com.houdaifa.stockmanagement.repository.RolesRepository;
import com.houdaifa.stockmanagement.services.RolesService;
import com.houdaifa.stockmanagement.validators.RolesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RolesServiceImpl implements RolesService {
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public RolesDto save(RolesDto rolesDto) {
        List<String>errors=RolesValidator.validate(rolesDto);
        if(!errors.isEmpty()){
            log.error("the role is invalid");
            throw new InvalidEntityException("invalid role ", ErrorCodes.ROLES_NOT_VALID,errors);
        }
        return RolesDto.fromEntity(rolesRepository.save(RolesDto.toEntity(rolesDto)));

    }

    @Override
    public RolesDto findById(Integer id) {
        if(id==null){
            log.error("the given id is null");
            return null;
        }
        Optional<Roles>roles=rolesRepository.findById(id);
        return Optional.of(RolesDto.fromEntity(roles.get())).orElseThrow(()->
         new EntityNotFoundException("Role with the id: "+id+"is not existed",ErrorCodes.ROLES_NOT_FOUND)

        );
    }

    @Override
    public void deleteById(Integer id) {
   if(id==null){
       log.error("the given id is null");
       return;
   }
   rolesRepository.deleteById(id);
    }

    @Override
    public List<RolesDto> findAll() {
        return rolesRepository.findAll().stream().map(RolesDto::fromEntity).collect(Collectors.toList());
    }
}
