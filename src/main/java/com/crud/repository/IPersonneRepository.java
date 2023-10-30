package com.crud.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crud.model.Personne;

@Repository
public interface IPersonneRepository extends JpaRepository<Personne, Integer> {

    Page<Personne> findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCaseOrId(String nom, String prenom, int id ,PageRequest pageable) ;
    Page<Personne> findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCase(String nom, String prenom, PageRequest pageable) ;
    @Query("SELECT p FROM personne p WHERE p.list = true ORDER BY p.epingle DESC")
    List<Personne> getPeopleWithListTrueAndPinnedFirst();
    Page<Personne> findAllByConnexionId( int id, PageRequest pageable);
    Page<Personne> findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCaseOrIdAndConnexionId(String nom, String prenom,int likeId, int id ,PageRequest pageable) ;
    Page<Personne> findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCaseAndConnexionId(String nom, String prenom,int id, PageRequest pageable) ;
}
