package com.jamli.gestiondestoks.repository;

import com.jamli.gestiondestoks.model.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneVenteRepository extends JpaRepository<LigneVente, Integer> {
    List<LigneVente> findAllByVenteId(Integer id);
    List<LigneVente> findAllByArticleId(Integer idArticle);
}
