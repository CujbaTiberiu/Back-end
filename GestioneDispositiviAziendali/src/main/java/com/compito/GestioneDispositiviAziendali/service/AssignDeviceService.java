package com.compito.GestioneDispositiviAziendali.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compito.GestioneDispositiviAziendali.model.AssignDevice;
import com.compito.GestioneDispositiviAziendali.model.AssignDevice.AssignDeviceBuilder;
import com.compito.GestioneDispositiviAziendali.model.Device;
import com.compito.GestioneDispositiviAziendali.model.TypeStatus;
import com.compito.GestioneDispositiviAziendali.model.User;
import com.compito.GestioneDispositiviAziendali.repository.AssignDeviceDAORepository;
import com.compito.GestioneDispositiviAziendali.repository.DeviceDAORepository;
import com.compito.GestioneDispositiviAziendali.repository.UserDAORepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AssignDeviceService {

	@Autowired AssignDeviceDAORepository db;
	@Autowired DeviceDAORepository dbDevice;
	@Autowired UserDAORepository dbUser;
	
	
	public AssignDevice insert(User user, Device device) {
	
    if (!dbUser.existsById(user.getId())) {
        throw new EntityNotFoundException("User doesn't exist!");
    }
    if (!dbDevice.existsById(device.getId())) {
        throw new EntityNotFoundException("Device doesn't exist!");
    }
    
    if(device.getTypeStatus() == TypeStatus.ASSIGNED ||  device.getTypeStatus() == TypeStatus.DISPOSED
    		||  device.getTypeStatus() == TypeStatus.MAINTENANCE) {
    	throw new EntityExistsException("Device is not available!");
    }
    

    AssignDevice newAssign= new AssignDevice();
    newAssign.setUser(user);
    newAssign.setDevice(device);
    user.getDevice().add(device);
    device.setTypeStatus(TypeStatus.ASSIGNED);
    device.setUser(user);
    db.save(newAssign);
    return newAssign;
}

	public AssignDevice update(AssignDevice ad, Long id) {
		if(!db.existsById(id)) {
			throw new EntityNotFoundException("Device assignment doesn't exist!");
		}
		db.save(ad);
		return ad;
	}	

	public String delete(Long id) {
	    Optional<AssignDevice> assignDeviceOptional = db.findById(id);
	    if (assignDeviceOptional.isEmpty()) {
	        throw new EntityNotFoundException("Device assignment doesn't exist!");
	    }
	    
	    AssignDevice assignDevice = assignDeviceOptional.get();
	    Device device = assignDevice.getDevice();
	    User user = assignDevice.getUser();
	    
	    device.setTypeStatus(TypeStatus.AVAILABLE);
	    device.setUser(null);
	    user.getDevice().remove(device);
	    
	    db.deleteById(id);
	    
	    return "Assignment deleted!";
	}


	public Optional<AssignDevice> getByID(long id) {
		if(!db.existsById(id)) {
		throw new EntityNotFoundException("Device assignment doesn't exist!");
		}
		return db.findById(id);
	}

		public List<AssignDevice> getAll() {
			return db.findAll();
		}

	
	}
	
