package com.ferrero.service;

import com.ferrero.model.Spitter;
import com.ferrero.repository.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


/**
 * Created by drugo on 02/07/2017.
 */
/*
    What’s interesting about SpitterUserService is that it has no idea how the user data is persisted.
    SpitterUserService doesn’t know or care what underlying data storage is used.
    In these manner the "configure" method in SecurityConfig also don't have to use "DataSource".
 */
@Service
public class SpitterUserDetailsService implements UserDetailsService {

    @Autowired
    private SpitterRepository spitterRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Spitter spitter = spitterRepository.findByUsername(username);
        if (spitter != null) {
            // Si rilascia allo spitter appena prelevato "l'autorità/ruolo" di SPITTER
            ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));
            spitter.setAuthorities(authorities);
            return spitter;
        }
        throw new UsernameNotFoundException("User '" + username + "' not found.");
    }
}
