package com.jamli.gestiondestoks.services.auth;

import com.jamli.gestiondestoks.dto.UtilisateurDto;
import com.jamli.gestiondestoks.exeption.EntityNotFoundException;
import com.jamli.gestiondestoks.exeption.ErrorCodes;
import com.jamli.gestiondestoks.model.Utilisateur;
import com.jamli.gestiondestoks.model.auth.ExtendedUser;
import com.jamli.gestiondestoks.repository.UtilisateurRepository;
import com.jamli.gestiondestoks.services.srategy.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    @Autowired
    private UtilisateurService service;
    //recuperer utilisateur avec roles
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("wselett");
        System.out.println(email);
        UtilisateurDto utilisateur = service.findByEmail(email);
        System.out.println("tawa t£jkhj");
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        utilisateur.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));




        return new ExtendedUser(utilisateur.getEmail(), utilisateur.getMoteDePasse(), utilisateur.getEntreprise().getId(), authorities);
    }
}
