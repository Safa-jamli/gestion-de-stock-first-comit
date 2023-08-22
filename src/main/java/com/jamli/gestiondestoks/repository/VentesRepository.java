package com.jamli.gestiondestoks.repository;

import com.jamli.gestiondestoks.model.LigneVente;
import com.jamli.gestiondestoks.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VentesRepository extends JpaRepository<Ventes, Integer> {
    Optional<Ventes> findVentesByCode(String code);



}
