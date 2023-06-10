package com.compito.GestioneDispositiviAziendali.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.compito.GestioneDispositiviAziendali.model.AssignDevice;
import com.compito.GestioneDispositiviAziendali.model.User;
import com.compito.GestioneDispositiviAziendali.service.DeviceService;
import com.compito.GestioneDispositiviAziendali.service.UserService;


@RestController
@RequestMapping("/api/users") 
public class UserController {
	
	@Autowired UserService userService;
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MODERATOR')")
	public ResponseEntity<List<User>> getUserAll() {
		return ResponseEntity.ok(userService.getAll());
	}
	
	@GetMapping("/page")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MODERATOR')")
	public ResponseEntity<Page<User>> getUserAllPageable(Pageable pageable) {
		return ResponseEntity.ok(userService.getAllPageable(pageable));
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MODERATOR')")
	public ResponseEntity<?> getUserByID(@PathVariable long id) {
		return ResponseEntity.ok(userService.getByID(id));
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> createUser(@RequestBody User u) {
		return ResponseEntity.ok(userService.insertUtente(u));
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> updateUser(@RequestBody User u, @PathVariable Long id) {
		return ResponseEntity.ok(userService.updateUtente(u));
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		return ResponseEntity.ok(userService.deleteUtente(id));
	}
	

}
