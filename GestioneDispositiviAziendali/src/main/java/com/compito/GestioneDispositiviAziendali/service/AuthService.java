package com.compito.GestioneDispositiviAziendali.service;

import com.compito.GestioneDispositiviAziendali.payload.LoginDto;
import com.compito.GestioneDispositiviAziendali.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
