package com.compito.PrenotaPostazioneAziendale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compito.PrenotaPostazioneAziendale.model.ERole;
import com.compito.PrenotaPostazioneAziendale.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
