package com.pieceperdu.backend.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Component;

import com.pieceperdu.backend.security.entities.AppUser;
import com.pieceperdu.backend.security.repositories.AppUserRepostory;
@AllArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService  {
    private final AppUserRepostory appUserRepostory;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appuser = appUserRepostory.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        appuser.getAppRoles().forEach(r -> {
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });
        return User
            .withUsername(appuser.getUsername())
            .password(appuser.getPassword())
            .authorities(authorities).build();
    }
    
}
