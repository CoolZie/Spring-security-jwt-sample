package com.pieceperdu.backend.services;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pieceperdu.backend.security.entities.AppRole;
import com.pieceperdu.backend.security.entities.AppUser;
import com.pieceperdu.backend.security.repositories.AppRoleRepostory;
import com.pieceperdu.backend.security.repositories.AppUserRepostory;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
@Service
@Transactional
@AllArgsConstructor

public class AccountServiceImpl implements AccountService {
    private AppUserRepostory appUserRepostory;
    private AppRoleRepostory appRoleRepostory;
    private PasswordEncoder passwordEncoder;
    @Override
    public AppUser addNewUser(AppUser user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        return appUserRepostory.save(user);
    }

    @Override
    public AppRole addnewRole(AppRole role) {
        return appRoleRepostory.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepostory.findByUsername(username).get();
        AppRole appRole = appRoleRepostory.findByRoleName(roleName);
        appUser.getAppRoles().add(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepostory.findByUsername(username).get();
    }

    @Override
    public List<AppUser> listUsers() {
        return appUserRepostory.findAll();
    }

    @Override
    public void delete(Long id) {
        appUserRepostory.deleteById(id);
    }

    @Override
    public void put(AppUser appUser, Long id) {
        AppUser user = appUserRepostory.findById(id).get();
        user.setUsername(appUser.getUsername());
        user.setPassword(appUser.getPassword());
        appUserRepostory.save(user);
    }
    
}
