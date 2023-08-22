package com.jamli.gestiondestoks.repository;

import com.jamli.gestiondestoks.dto.CommandeFournisseurDto;
import com.jamli.gestiondestoks.model.CommandeClient;
import com.jamli.gestiondestoks.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {

    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);

    List<CommandeClient> findAllByFournisseurId(Integer id);
}
