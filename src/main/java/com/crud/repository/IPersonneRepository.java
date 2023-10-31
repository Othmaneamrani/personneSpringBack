package com.crud.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crud.model.Personne;

@Repository
public interface IPersonneRepository extends JpaRepository<Personne, Integer> {

    Page<Personne> findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCaseOrId(String nom, String prenom, int id ,PageRequest pageable) ;
    Page<Personne> findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCase(String nom, String prenom, PageRequest pageable) ;
    @Query("SELECT p FROM personne p WHERE p.connexion.id = :id AND p.list = true ORDER BY p.epingle DESC")
    List<Personne> getPeopleWithListTrueAndPinnedFirst(int id);
    List<Personne> findAllByConnexionId(int id);
    Page<Personne> findAllByConnexionId(int id, PageRequest pageable);
    Page<Personne> findByConnexionIdAndNomContainingIgnoreCaseOrConnexionIdAndPrenomContainingIgnoreCaseOrConnexionIdAndId(int connexionId1, String nom,int connexionId2 ,String prenom ,int connexionId3,int id,PageRequest pageable);
    Page<Personne> findByConnexionIdAndNomContainingIgnoreCaseOrConnexionIdAndPrenomContainingIgnoreCase(int connexionId1, String nom,int connexionId2 ,String prenom ,PageRequest pageable);
}
