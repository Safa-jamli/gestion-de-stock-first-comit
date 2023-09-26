package com.jamli.gestiondestoks.controller;

import com.jamli.gestiondestoks.dto.auth.AuthenticationRequest;
import com.jamli.gestiondestoks.dto.auth.AuthenticationResponse;
import com.jamli.gestiondestoks.model.Utilisateur;
import com.jamli.gestiondestoks.model.auth.ExtendedUser;
import com.jamli.gestiondestoks.repository.UtilisateurRepository;
import com.jamli.gestiondestoks.services.auth.ApplicationUserDetailsService;
import com.jamli.gestiondestoks.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.jamli.gestiondestoks.utils.Constants.AUTHENTICATION_ENDPOINT;

@RestController
@RequestMapping(AUTHENTICATION_ENDPOINT)
public class AthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ApplicationUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    //authen l'utisateur
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        Utilisateur utilisateur = utilisateurRepository.findByEmail(request.getLogin()).orElseThrow(()-> new UsernameNotFoundException("LONG NOT EXIST"));
        Boolean aBoolean=    passwordEncoder.matches(request.getPassword(), utilisateur.getMoteDePasse());
        if (!aBoolean) throw new RuntimeException();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getLogin(),request.getPassword()));
        // final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());
        final String jwt = jwtUtil.generateToken(utilisateur);
        return ResponseEntity.ok(AuthenticationResponse.builder().accesstoken(jwt).build());

    }
}
