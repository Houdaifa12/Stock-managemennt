package com.houdaifa.stockmanagement.Dto;

import com.houdaifa.stockmanagement.model.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtilisateurDto {
    private Integer id;
    private String nom;

    private String prenom;

    private String email;

    private Instant dateDeNaissance;

    private String motDePasse;

    private AddressDto adresse;


    private String photo;

    private EntrepriseDto entreprise;

    private List<RolesDto> roles;
    public static UtilisateurDto fromEntity(Utilisateur utilisateur){
        if(utilisateur==null){
            return null;
        }
        else{
            UtilisateurDto utilisateurDto=new UtilisateurDto();
            utilisateurDto.setId(utilisateur.getId());
            utilisateurDto.setEmail(utilisateur.getEmail());
            utilisateurDto.setPhoto(utilisateur.getPhoto());
            utilisateurDto.entreprise.fromEntity(utilisateur.getEntreprise());
            utilisateurDto.adresse.fromEntity(utilisateur.getAdresse());
            utilisateurDto.setNom(utilisateur.getNom());
            utilisateurDto.setDateDeNaissance(utilisateur.getDateDeNaissance());
            utilisateurDto.setMotDePasse(utilisateur.getMotDePasse());
            utilisateurDto.setPrenom(utilisateur.getPrenom());
            return  utilisateurDto;
        }
    }
    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){
        if(utilisateurDto==null){
            return null;
        }
        else{
            Utilisateur utilisateur =new Utilisateur();
            utilisateur.setNom(utilisateurDto.getNom());
            utilisateur.setAdresse(utilisateurDto.adresse.toEntity(utilisateurDto.getAdresse()));
            utilisateur.setEmail(utilisateurDto.getEmail());
            utilisateur.setEntreprise(utilisateurDto.entreprise.toEntity(utilisateurDto.getEntreprise()));
            utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
            utilisateur.setDateDeNaissance(utilisateurDto.getDateDeNaissance());
            utilisateur.setPhoto(utilisateurDto.getPhoto());
            utilisateur.setPrenom(utilisateurDto.getPrenom());
            return utilisateur;
        }
    }


}
