package com.compito.GestioneDispositiviAziendali.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.compito.GestioneDispositiviAziendali.model.AssignDevice;
import com.compito.GestioneDispositiviAziendali.model.AssignDevice.AssignDeviceBuilder;
import com.compito.GestioneDispositiviAziendali.model.Device;
import com.compito.GestioneDispositiviAziendali.model.User;
import com.compito.GestioneDispositiviAziendali.service.AssignDeviceService;
import com.compito.GestioneDispositiviAziendali.service.DeviceService;
import com.compito.GestioneDispositiviAziendali.service.UserService;


@RestController
@RequestMapping("/api/assign-devices")
public class AssignDeviceController {
	
	@Autowired AssignDeviceService assignService;
	@Autowired UserService userService;
	@Autowired DeviceService deviceService;
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MODERATOR')")
	public ResponseEntity<List<AssignDevice>> getAll() {
		return ResponseEntity.ok(assignService.getAll());
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MODERATOR')")
	public ResponseEntity<?> getPrenotazioneByID(@PathVariable long id) {
		return ResponseEntity.ok(assignService.getByID(id));
	}
	
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<AssignDevice> create(@RequestParam Long idUser, @RequestParam Long idDevice) {
		Optional<User> user = userService.getByID(idUser);
		Optional<Device> device = deviceService.getByID(idDevice);
		return ResponseEntity.ok(assignService.insert(user.get(), device.get()));
		
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<AssignDevice> update(@RequestBody AssignDevice ad, @PathVariable Long id) throws Exception {
		return ResponseEntity.ok(assignService.update(ad, id));
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		return ResponseEntity.ok(assignService.delete(id));
		
	}

}
