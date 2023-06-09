package com.compito.GestioneDispositiviAziendali.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compito.GestioneDispositiviAziendali.model.ERole;
import com.compito.GestioneDispositiviAziendali.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
