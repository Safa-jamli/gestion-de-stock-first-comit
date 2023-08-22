package com.jamli.gestiondestoks.repository;

import com.jamli.gestiondestoks.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
