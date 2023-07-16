package com.houdaifa.stockmanagement.Dto;

import com.houdaifa.stockmanagement.model.Ventes;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VentesDto {
    private Integer id;
    private String code;
    private Instant dateVente;
    private String commentaire;
    public static VentesDto fromEntity(Ventes ventes){
        if(ventes==null){
            return null;
        }
        else{
            VentesDto ventesDto=new VentesDto();
            ventesDto.setDateVente(ventes.getDateVente());
            ventesDto.setId(ventes.getId());
            ventesDto.setCommentaire(ventes.getCommentaire());
            ventesDto.setCode(ventes.getCode());
            return ventesDto;
        }
    }
    public static Ventes fromEntity(VentesDto ventesDto){
        if(ventesDto==null){
            return null;
        }
        else{
            Ventes ventes=new Ventes();
            ventes.setDateVente(ventesDto.getDateVente());
            ventes.setId(ventesDto.getId());
            ventes.setCommentaire(ventesDto.getCommentaire());
            ventes.setCode(ventesDto.getCode());
            return ventes;
        }
    }
}
