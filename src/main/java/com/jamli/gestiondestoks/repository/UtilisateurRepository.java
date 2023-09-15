package com.jamli.gestiondestoks.repository;

import com.jamli.gestiondestoks.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    Optional<Utilisateur> findByEmail(String email);

    @Query(nativeQuery = true , value = "SELECT * FROM utilisateur WHERE email= :email and motdepasse= :passwd")
    Utilisateur findByEmailAndMoteDePasse(@Param("email") String email,@Param("passwd") String passwd);
}
