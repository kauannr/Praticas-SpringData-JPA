package com.example.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.entities.Telefone;

public interface TelefoneRespository extends JpaRepository<Telefone, Long> {

}
