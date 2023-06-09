package com.compito.GestioneDispositiviAziendali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compito.GestioneDispositiviAziendali.model.Device;
import com.compito.GestioneDispositiviAziendali.model.TypeDevice;

@Repository
public interface DeviceDAORepository extends JpaRepository<Device, Long>{
	
	public Boolean existsByTypeDevice (TypeDevice type);

}
