package com.compito.GestioneDispositiviAziendali.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.compito.GestioneDispositiviAziendali.model.User;
import com.compito.GestioneDispositiviAziendali.repository.UserDAORepository;
import com.compito.GestioneDispositiviAziendali.repository.UserPageableRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired UserDAORepository db;
	@Autowired UserPageableRepository dbPageable;
	
	
	public Page<User> getAllPageable(Pageable pageable){
		return dbPageable.findAll(pageable);
	}
	
	public User insertUtente(User u) {
		if(db.existsByEmail(u.getEmail())) {
			throw new EntityExistsException("User with mail " + u.getEmail() + " already exists!");
		} else {
			db.save(u);
		}
		return u;
	}
	
	public User updateUtente(User u) {
		if(!db.existsById(u.getId())) {
			throw new EntityNotFoundException("User doesn't exist!");
		}
		db.save(u);
		return u;
	}
	
	public String deleteUtente(Long id) {
		if(!db.existsById(id)) {
			throw new EntityExistsException("User doesn't exist!");
		}
		db.deleteById(id);
		return "User deleted!";
	}
	
	public Optional<User> getByID(long id) {
		if(!db.existsById(id)) {
			throw new EntityNotFoundException("User doesn't exist!");
		}
		return db.findById(id);
	}
	
	public List<User> getAll() {
		return db.findAll();
	}
	
}
