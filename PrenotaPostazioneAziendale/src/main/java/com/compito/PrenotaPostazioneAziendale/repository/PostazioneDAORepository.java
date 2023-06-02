package com.compito.PrenotaPostazioneAziendale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compito.PrenotaPostazioneAziendale.model.Postazione;

@Repository
public interface PostazioneDAORepository extends JpaRepository<Postazione, Long>{

}
