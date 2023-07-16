package com.houdaifa.stockmanagement.Dto;

import com.houdaifa.stockmanagement.model.LigneVente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LigneVenteDto {
    private Integer id;
    private VentesDto Vente;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    public static LigneVenteDto fromEntity(LigneVente ligneVente){
        if(ligneVente==null){
            return null;
        }
        else{
            LigneVenteDto ligneVenteDto=new LigneVenteDto();
            ligneVenteDto.setId(ligneVente.getId());
            ligneVenteDto.setQuantite(ligneVente.getQuantite());
            ligneVenteDto.setPrixUnitaire(ligneVente.getPrixUnitaire());
            return ligneVenteDto;
        }
    }
    public static LigneVente toEntity(LigneVenteDto ligneVenteDto){
        if(ligneVenteDto==null){
            return null;
        }
        else{
            LigneVente ligneVente=new LigneVente();
            ligneVente.setQuantite(ligneVenteDto.getQuantite());
            ligneVente.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());
            return ligneVente;
        }
    }
}
