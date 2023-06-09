package com.compito.GestioneDispositiviAziendali.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compito.GestioneDispositiviAziendali.model.Device;
import com.compito.GestioneDispositiviAziendali.model.User;
import com.compito.GestioneDispositiviAziendali.repository.DeviceDAORepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DeviceService {

	@Autowired DeviceDAORepository db;
	
	public Device insert(Device d) {
			db.save(d);
			return d;
	}
	
	public Device update(Device d) {
		if(!db.existsById(d.getId())) {
			throw new EntityNotFoundException("Device doesn't exist!");
		}
		db.save(d);
		return d;
	}
	
	public String delete(Long id) {
		if(!db.existsById(id)) {
			throw new EntityExistsException("Device doesn't exist!");
		}
		db.deleteById(id);
		return "Device deleted!";
	}
	
	public Optional<Device> getByID(long id) {
		if(!db.existsById(id)) {
			throw new EntityNotFoundException("Device doesn't exist!");
		}
		return db.findById(id);
	}
	
	public List<Device> getAll() {
		return db.findAll();
	}
}
