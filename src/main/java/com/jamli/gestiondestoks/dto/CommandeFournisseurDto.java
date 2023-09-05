package com.jamli.gestiondestoks.dto;

import com.jamli.gestiondestoks.model.CommandeClient;
import com.jamli.gestiondestoks.model.CommandeFournisseur;
import com.jamli.gestiondestoks.model.EtatCommande;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommandeFournisseurDto {
    private Integer id;
    private  String code;
    private Instant dateCommande;
    private FournisseurDto fournisseur;
    private EtatCommande etatCommande;
    private Integer idEntreprise;
    private List<LigneCommandeFournisseurDto> lignecommandefournisseur;

    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur) {
        if (commandeFournisseur == null) {
            return null;
        }
        return CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .dateCommande(commandeFournisseur.getDateCommande())
                .fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
                .etatCommande(commandeFournisseur.getEtatCommande())
                .idEntreprise(commandeFournisseur.getIdEntreprise())
                .build();
    }

    public static CommandeFournisseur toEntity(CommandeFournisseurDto dto) {
        if (dto == null) {
            return null;
        }
        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setId(dto.getId());
        commandeFournisseur.setCode(dto.getCode());
        commandeFournisseur.setDateCommande(dto.getDateCommande());
        commandeFournisseur.setFournisseur(FournisseurDto.toEntity(dto.getFournisseur()));
        commandeFournisseur.setIdEntreprise(dto.getIdEntreprise());
        commandeFournisseur.setEtatCommande(dto.getEtatCommande());
        return commandeFournisseur;
    }

    public boolean isCommandeLivree() {
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }

}
