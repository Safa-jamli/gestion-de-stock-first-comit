package com.jamli.gestiondestoks.repository;

import com.jamli.gestiondestoks.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
}
