package com.compito.GestioneDispositiviAziendali.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.compito.GestioneDispositiviAziendali.model.User;


@Repository
public interface UserPageableRepository extends PagingAndSortingRepository<User, Long>{

}
