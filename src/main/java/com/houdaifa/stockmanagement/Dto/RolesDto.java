package com.houdaifa.stockmanagement.Dto;

import com.houdaifa.stockmanagement.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RolesDto {
    private Integer id;
    private String roleName;
    private UtilisateurDto utilisateur;
    public static RolesDto fromEntity(Roles roles){
        if(roles==null){
            return null;
        }
        else{
            RolesDto rolesDto=new RolesDto();
            rolesDto.setRoleName(roles.getRoleName());
            rolesDto.setId(roles.getId());
            rolesDto.utilisateur.fromEntity(roles.getUtilisateur());
            return rolesDto;
        }
    }
    public static Roles toEntity(RolesDto rolesDto){
        if(rolesDto==null){
            return null;
        }
        else{
            Roles roles=new Roles();
            roles.setRoleName(rolesDto.getRoleName());
            roles.setId(rolesDto.getId());
            roles.setUtilisateur(rolesDto.utilisateur.toEntity(rolesDto.getUtilisateur()));
            return roles;
        }
    }
}
