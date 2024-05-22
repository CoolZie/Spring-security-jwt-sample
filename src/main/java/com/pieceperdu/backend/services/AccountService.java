package com.pieceperdu.backend.services;


import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pieceperdu.backend.security.entities.AppRole;
import com.pieceperdu.backend.security.entities.AppUser;

public interface AccountService {
    AppUser addNewUser(AppUser user);
    AppRole addnewRole(AppRole role);
    void addRoleToUser(String username, String roleName);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();
    void delete(Long id);
    void put(AppUser appUser, Long id);
}
