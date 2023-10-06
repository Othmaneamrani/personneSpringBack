package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Login;

@Repository
public interface ILoginRepository extends JpaRepository<Login, Integer> {

}
