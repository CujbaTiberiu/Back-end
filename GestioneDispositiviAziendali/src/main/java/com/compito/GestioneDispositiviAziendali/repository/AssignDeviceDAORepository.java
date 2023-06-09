package com.compito.GestioneDispositiviAziendali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compito.GestioneDispositiviAziendali.model.AssignDevice;

@Repository
public interface AssignDeviceDAORepository extends JpaRepository<AssignDevice, Long>{

}
