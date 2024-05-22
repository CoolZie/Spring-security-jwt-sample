package com.pieceperdu.backend.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pieceperdu.backend.security.entities.AppUser;
@Repository
public interface AppUserRepostory extends JpaRepository<AppUser, Long>{
    Optional<AppUser> findByUsername(String username);
}
