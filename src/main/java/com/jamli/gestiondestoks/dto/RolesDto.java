package com.jamli.gestiondestoks.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jamli.gestiondestoks.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RolesDto {
    private Integer id;
    private String roleName;
    @JsonIgnore
    private UtilisateurDto utilisateur;
    public static RolesDto fromEntity(Roles roles) {
        if (roles == null) {
            return null;
        }
        return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .build();
    }

    public static Roles toEntity(RolesDto dto) {
        if (dto == null) {
            return null;
        }
        Roles roles = new Roles();
        roles.setId(dto.getId());
        roles.setRoleName(dto.getRoleName());
       // roles.setUtilisateur(UtilisateurDto.toEntity(dto.getUtilisateur()));
        return roles;
    }

}