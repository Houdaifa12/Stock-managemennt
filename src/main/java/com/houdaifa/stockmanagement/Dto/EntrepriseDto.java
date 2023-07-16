package com.houdaifa.stockmanagement.Dto;

import com.houdaifa.stockmanagement.model.CommandeClient;
import com.houdaifa.stockmanagement.model.Entreprise;
import com.houdaifa.stockmanagement.model.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntrepriseDto {
    private Integer id;
    private String nom;
    private String description;
    private AddressDto address;
    protected String codeFiscal;
    private String photo;
    private String email;
    public String numTel;
    private String steWeb;
    private List<UtilisateurDto>utilisateurs;
   public  static EntrepriseDto fromEntity(Entreprise entreprise){
       if(entreprise==null){
           return null;
       }
       else{
           EntrepriseDto entrepriseDto=new EntrepriseDto();
           entrepriseDto.setId(entreprise.getId());
           entrepriseDto.setNom(entreprise.getNom());
           List<UtilisateurDto>utilisateurDtos=new ArrayList<>();
           for(Utilisateur utilisateur:entreprise.getUtilisateurs()){
               UtilisateurDto utilisateurDto=new UtilisateurDto();
               utilisateurDto.fromEntity(utilisateur);
               utilisateurDtos.add(utilisateurDto);

           }

           entrepriseDto.setUtilisateurs(utilisateurDtos);
           entrepriseDto.setPhoto(entreprise.getPhoto());
           entrepriseDto.setCodeFiscal(entreprise.getCodeFiscal());
           entrepriseDto.setNumTel(entreprise.getNumTel());
           entrepriseDto.setSteWeb(entreprise.getSteweb());
           entrepriseDto.setDescription(entreprise.getDescription());
           entrepriseDto.setEmail(entreprise.getEmail());
           return entrepriseDto;
       }
   }
    public static Entreprise toEntity(EntrepriseDto entrepriseDto){
        if(entrepriseDto==null){
            return null;
        }
        else{
            Entreprise entreprise=new Entreprise();
            entreprise.setId(entrepriseDto.getId());
            entreprise.setNom(entrepriseDto.getNom());
            List<Utilisateur>utilisateurs1=new ArrayList<>();
            for(UtilisateurDto utilisateurDto :entrepriseDto.getUtilisateurs()){
                Utilisateur utilisateur=new Utilisateur();
                utilisateur=utilisateurDto.toEntity(utilisateurDto);
                utilisateurs1.add(utilisateur);
            }
            entreprise.setUtilisateurs(utilisateurs1);
            entreprise.setPhoto(entrepriseDto.getPhoto());
            entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
            entreprise.setNumTel(entrepriseDto.getNumTel());
            entreprise.setSteweb(entrepriseDto.getSteWeb());
            entreprise.setDescription(entrepriseDto.getDescription());
            entreprise.setEmail(entrepriseDto.getEmail());
            return entreprise;
        }
    }

}
