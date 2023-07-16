package com.houdaifa.stockmanagement.Dto;

import com.houdaifa.stockmanagement.model.CommandeFournisseur;
import com.houdaifa.stockmanagement.model.Fournisseur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FournisseurDto {
    private Integer id;
    private String nom;
    private String prenom;
    private AddressDto address;
    private String photo;
    private String mail;
    private String numTel;
    private List<CommandeFournisseurDto>commandeFournisseurs;

    public static Fournisseur toEntity(FournisseurDto FournisseurDto){
        if(FournisseurDto==null){
            return null;
        }
        Fournisseur Fournisseur=new Fournisseur();
        Fournisseur.setAdresse(FournisseurDto.getAddress().toEntity(FournisseurDto.getAddress()));
        Fournisseur.setMail(FournisseurDto.getMail());
        Fournisseur.setNumTel(FournisseurDto.getNumTel());
        Fournisseur.setAdresse(FournisseurDto.getAddress().toEntity(FournisseurDto.getAddress()));
        Fournisseur.setPhoto(FournisseurDto.getPhoto());
        Fournisseur.setNom(FournisseurDto.getNom());
        Fournisseur.setPrenom(FournisseurDto.getPrenom());
        return Fournisseur;
    }
    public static FournisseurDto fromEntity(Fournisseur fournisseur){
        if(fournisseur==null){
            return  null;
        }
        else{
            FournisseurDto fournisseurDto =new FournisseurDto();
            fournisseurDto.setNom(fournisseur.getNom());
            fournisseurDto.setPrenom(fournisseur.getPrenom());
            fournisseurDto.setMail(fournisseur.getMail());
            List<CommandeFournisseurDto>commandeFournisseurDtos=new ArrayList<>();
            for(CommandeFournisseur commandeFournisseur:fournisseur.getCommandeFoirnisseurs()){
                CommandeFournisseurDto commandeFournisseurDto=new CommandeFournisseurDto();
                commandeFournisseurDto.fromEntity(commandeFournisseur);
                commandeFournisseurDtos.add(commandeFournisseurDto);

            }

            fournisseurDto.setCommandeFournisseurs(commandeFournisseurDtos);
            fournisseurDto.address.fromEntity(fournisseur.getAdresse());
            fournisseurDto.setPhoto(fournisseurDto.getPhoto());
            fournisseurDto.setNumTel(fournisseurDto.getNumTel());
            return fournisseurDto;
        }
    }


}
