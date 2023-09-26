package com.jamli.gestiondestoks.services.impl;

import com.jamli.gestiondestoks.dto.UserDtoForCreate;
import com.jamli.gestiondestoks.dto.UtilisateurDto;
import com.jamli.gestiondestoks.exeption.EntityNotFoundException;
import com.jamli.gestiondestoks.exeption.ErrorCodes;
import com.jamli.gestiondestoks.model.Utilisateur;
import com.jamli.gestiondestoks.repository.UtilisateurRepository;
import com.jamli.gestiondestoks.services.srategy.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    PasswordEncoder passwordEncoder;

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;

    }

    @Override
    public Utilisateur save(UserDtoForCreate dto) {
        //List<String> errors = UtilisateurValidator.validate(dto);
     /*   if (!errors.isEmpty()) {
            log.error("Utilisateur is not valid {}", dto);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
        }*/
        System.out.println("innnnnnnnnnnnnnnnnn sqve ");
        return utilisateurRepository.save(mappingUser(dto));
    }

private Utilisateur mappingUser(UserDtoForCreate userDtoForCreate){
        Utilisateur utilisateur =new Utilisateur();
        utilisateur.setEmail(userDtoForCreate.getEmail());
        utilisateur.setNom(userDtoForCreate.getNom());
        utilisateur.setPrenom(utilisateur.getPrenom());
        utilisateur.setMoteDePasse(passwordEncoder.encode(userDtoForCreate.getMoteDePasse()));
        return utilisateur;

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
        System.out.println("email     : "+email);
        try{
            Utilisateur utilisateur = utilisateurRepository.findByEmail(email).orElse(null);
            log.info("userrrrrrrrrrrr issssssssssssss             ",utilisateur.getRoles().get(0).getRoleName());

        }catch (Exception e){
            e.getStackTrace();
        }

        return utilisateurRepository.findByEmail(email)
                .map(UtilisateurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur avec l'email = " + email + " n' ete trouve dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
                );

    }}