package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Personne;

@Repository
public interface IPersonneRepository extends JpaRepository<Personne, Integer> {

}
