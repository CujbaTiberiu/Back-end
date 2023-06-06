package com.compito.PrenotaPostazioneAziendale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.compito.PrenotaPostazioneAziendale.model.Postazione;
import com.compito.PrenotaPostazioneAziendale.model.TipoPostazione;

@Repository
public interface PostazioneDAORepository extends JpaRepository<Postazione, Long>{

	@Query("SELECT p FROM Postazione p WHERE p.edificio.citta = :citta AND p.tipo = :tipo")
	public List<Postazione> findByCittaAndTipo(String citta, TipoPostazione tipo);
}
