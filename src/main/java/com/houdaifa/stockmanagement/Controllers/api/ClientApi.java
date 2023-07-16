package com.houdaifa.stockmanagement.Controllers.api;

import com.houdaifa.stockmanagement.Dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.houdaifa.stockmanagement.utils.Constante.APP_ROOT;

public interface ClientApi {
    @PostMapping(value = APP_ROOT+"/clients/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(@RequestBody ClientDto ClientDto);
    @GetMapping(value = APP_ROOT+"/clients/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();
    @DeleteMapping(value = APP_ROOT+"/clients/delete/{idClient}",consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idClient") Integer id);
    @GetMapping(value = APP_ROOT+"/clients/{idClient}",params = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(@PathVariable("idClient") Integer id);

}
