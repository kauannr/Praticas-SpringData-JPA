package com.example.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.entities.UsuarioSpring;

import jakarta.persistence.LockModeType;

import java.util.*;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioSpring, Long> {

    @Lock(LockModeType.READ)
    @Query("select p from UsuarioSpring p where p.nome = :nomee")
    public UsuarioSpring buscaPorNome(@Param("nomee") String nome);

    @Lock(LockModeType.READ)
    @Query("select p from UsuarioSpring p where p.nome like %?1%")
    public List<UsuarioSpring> buscaContemNome(String nome);

    @Modifying
    @Transactional
    @Query("delete from UsuarioSpring u where u.nome like ?1")
    public void deletePorNome(String nome);

    @Modifying
    @Transactional
    @Query("update UsuarioSpring u set u.email = ?1 where u.nome = ?2")
    public void updateEmailPorNome(String email, String nome);
}
