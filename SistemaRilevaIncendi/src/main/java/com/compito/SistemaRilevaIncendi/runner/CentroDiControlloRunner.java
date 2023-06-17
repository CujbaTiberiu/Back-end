package com.compito.SistemaRilevaIncendi.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.compito.SistemaRilevaIncendi.models.CentroDiControllo;
import com.compito.SistemaRilevaIncendi.models.Rillevamento;
import com.compito.SistemaRilevaIncendi.models.Sonda;
import com.compito.SistemaRilevaIncendi.repository.CentroDiControlloRepository;
import com.compito.SistemaRilevaIncendi.repository.SondaRepository;

@Component
public class CentroDiControlloRunner implements CommandLineRunner{
	
	@Autowired CentroDiControlloRepository cdcRepo;
	@Autowired SondaRepository sondaRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		
	
		Rillevamento r = new Rillevamento();
		CentroDiControllo cdc = new CentroDiControllo();
		cdc.setNome("Centro Generale");
		cdcRepo.save(cdc);
	
		
		r.aggiungi(cdc);
		
		Sonda s1 = new Sonda("30.21", "25.20", 3);
		Sonda s2 = new Sonda("50.10", "90.20", 5);
		Sonda s3 = new Sonda("66", "29.20", 6);
		sondaRepo.save(s1);
		sondaRepo.save(s2);
		sondaRepo.save(s3);
		
		//r.inviaRilevamentoIncendio(s1);
		cdc.update(s1);
	}
	
	
	
}
