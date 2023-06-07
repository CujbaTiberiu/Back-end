package com.compito.PrenotaPostazioneAziendale.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.compito.PrenotaPostazioneAziendale.model.Utente;

@Repository
public interface UtentePageableRepository extends PagingAndSortingRepository<Utente, Long>{

}
