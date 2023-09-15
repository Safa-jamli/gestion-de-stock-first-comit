package com.jamli.gestiondestoks.services.impl;

import com.jamli.gestiondestoks.dto.UtilisateurDto;
import com.jamli.gestiondestoks.exeption.EntityNotFoundException;
import com.jamli.gestiondestoks.exeption.ErrorCodes;
import com.jamli.gestiondestoks.exeption.InvalidEntityException;
import com.jamli.gestiondestoks.repository.UtilisateurRepository;
import com.jamli.gestiondestoks.services.srategy.UtilisateurService;
import com.jamli.gestiondestoks.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;

    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        List<String> errors = UtilisateurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Utilisateur is not valid {}", dto);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
        }

        return UtilisateurDto.fromEntity(
                utilisateurRepository.save(
                        UtilisateurDto.toEntity(dto)
                )
        );
    }


    @Override
    public UtilisateurDto findById(Integer id) {
        if (id == null) {
            log.error("Utilisateur ID is null");
            return null;
        }
        return utilisateurRepository.findById(id)
                .map(UtilisateurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
                );
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Utilisateur ID is null");
            return;
        }
        utilisateurRepository.deleteById(id);
    }


    @Override
    public UtilisateurDto findByEmail(String email) {
        return utilisateurRepository.findUtilisateurByEmail(email)
                .map(UtilisateurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur avec l'email = " + email + " n' ete trouve dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
                );
    }
}
