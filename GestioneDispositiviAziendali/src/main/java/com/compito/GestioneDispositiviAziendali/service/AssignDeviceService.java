package com.compito.GestioneDispositiviAziendali.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compito.GestioneDispositiviAziendali.model.AssignDevice;
import com.compito.GestioneDispositiviAziendali.repository.AssignDeviceDAORepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AssignDeviceService {

	@Autowired AssignDeviceDAORepository db;
	
	
	public AssignDevice insert(AssignDevice ad) {
		db.save(ad);
		return ad;
}

	public AssignDevice update(AssignDevice ad) {
		if(!db.existsById(ad.getId())) {
			throw new EntityNotFoundException("AssignDevice doesn't exist!");
		}
		db.save(ad);
		return ad;
	}	

	public String delete(Long id) {
		if(!db.existsById(id)) {
		throw new EntityExistsException("AssignDevice doesn't exist!");
	}
		db.deleteById(id);
		return "Device deleted!";
	}

	public Optional<AssignDevice> getByID(long id) {
		if(!db.existsById(id)) {
		throw new EntityNotFoundException("AssignDevice doesn't exist!");
		}
		return db.findById(id);
	}

		public List<AssignDevice> getAll() {
			return db.findAll();
		}
	}
	
