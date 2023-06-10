package com.compito.GestioneDispositiviAziendali.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.compito.GestioneDispositiviAziendali.model.Device;
import com.compito.GestioneDispositiviAziendali.service.DeviceService;


@RestController
@RequestMapping("/api/devices")
public class DeviceController {

	@Autowired DeviceService deviceService;
	
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MODERATOR')")
	public ResponseEntity<List<Device>> getAll() {
		return ResponseEntity.ok(deviceService.getAll());
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MODERATOR')")
	public ResponseEntity<?> getByID(@PathVariable long id) {
		return ResponseEntity.ok(deviceService.getByID(id));
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Device> create(@RequestBody Device d) {
		return ResponseEntity.ok(deviceService.insert(d));
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Device> update(@RequestBody Device d, @PathVariable Long id) {
		return ResponseEntity.ok(deviceService.update(d));
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		return ResponseEntity.ok(deviceService.delete(id));
	}
}
