package com.pieceperdu.backend.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pieceperdu.backend.security.entities.AppRole;
@Repository
public interface AppRoleRepostory extends JpaRepository<AppRole, Long>{
    AppRole findByRoleName(String roleName);
}
