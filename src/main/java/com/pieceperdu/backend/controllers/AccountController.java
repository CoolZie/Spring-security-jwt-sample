package com.pieceperdu.backend.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.pieceperdu.backend.security.entities.AppUser;
import com.pieceperdu.backend.security.jwt.JwtService;
import com.pieceperdu.backend.services.AccountService;

import lombok.AllArgsConstructor;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class AccountController {
    private final AccountService accountService;
    private JwtService jwtService;

@DeleteMapping("")
public String delete(@RequestParam Long id) {
    accountService.delete(id);
    return "User deleted";
}
@PutMapping("")
public String put(@RequestBody AppUser appUser, @RequestParam Long id) {
    accountService.put(appUser, id);
    return "User updated";
}

@GetMapping("")
 public List<AppUser> get() {
     return accountService.listUsers();
 }

 @PostMapping("")
 public AppUser post(@RequestBody AppUser appUser) {
     return accountService.addNewUser(appUser);
 }
}
