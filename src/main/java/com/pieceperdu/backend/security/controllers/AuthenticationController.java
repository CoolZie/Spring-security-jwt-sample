package com.pieceperdu.backend.security.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.pieceperdu.backend.security.DTO.UserDTO;
import com.pieceperdu.backend.security.services.AuthenticationService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private AuthenticationService authenticationService;
    @PostMapping(value = "/login", consumes = "application/json")
    public String login(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO.getUsername());
        System.out.println(userDTO.getPassword());
        String jwt = authenticationService.login(userDTO);
        return jwt;
    }

    @GetMapping("/login")
    public String login() {
        return "jwt";
    }
}
