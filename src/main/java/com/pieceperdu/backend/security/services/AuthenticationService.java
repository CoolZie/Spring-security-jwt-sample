package com.pieceperdu.backend.security.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.pieceperdu.backend.security.DTO.UserDTO;
import com.pieceperdu.backend.security.entities.AppUser;
import com.pieceperdu.backend.security.jwt.JwtService;
import com.pieceperdu.backend.security.repositories.AppUserRepostory;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class AuthenticationService {
    private AuthenticationManager authenticationManager;
    private AppUserRepostory appUserRepostory;
    private JwtService jwtService;
    public String login(UserDTO userDTO) {
        UsernamePasswordAuthenticationToken authResult = new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword());
        authenticationManager.authenticate(authResult);
        AppUser appUser = appUserRepostory.findByUsername(userDTO.getUsername()).get();
        return jwtService.generateToken(appUser);
    }
}

