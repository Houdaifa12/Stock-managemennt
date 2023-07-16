package com.houdaifa.stockmanagement.Dto;

import com.houdaifa.stockmanagement.model.Adresse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private String adresse1;
    private String adresse2;
    private String ville;
    private String codePostale;
    private String pays;
    public  AddressDto fromEntity(Adresse address){
        if(address==null){
            return null;
        }
       else{
           AddressDto addressDto=new AddressDto();
            addressDto.setAdresse1(address.getAdresse1());
            addressDto.setAdresse2(address.getAdresse1());
            addressDto.setPays(address.getPays());
            addressDto.setVille(address.getVille());
            addressDto.setCodePostale(address.getCodePostale());
            return addressDto;
        }
    }
    public Adresse toEntity(AddressDto addressDto){
        Adresse adresse=new Adresse();
        adresse.setAdresse1(addressDto.getAdresse1());
        adresse.setAdresse2(addressDto.getAdresse1());
        adresse.setPays(addressDto.getPays());
        adresse.setVille(addressDto.getVille());
        adresse.setCodePostale(addressDto.getCodePostale());
        return adresse;

    }

}
