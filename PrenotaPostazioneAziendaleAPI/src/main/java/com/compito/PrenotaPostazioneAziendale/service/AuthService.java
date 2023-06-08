package com.compito.PrenotaPostazioneAziendale.service;

import com.compito.PrenotaPostazioneAziendale.payload.LoginDto;
import com.compito.PrenotaPostazioneAziendale.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
