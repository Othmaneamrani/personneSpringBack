package com.crud.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Personne;

@Repository
public interface IPersonneRepository extends JpaRepository<Personne, Integer> {

    Page<Personne> findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCaseOrId(String nom, String prenom, int id ,PageRequest pageable);
    Page<Personne> findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCase(String nom, String prenom, PageRequest pageable);

}
