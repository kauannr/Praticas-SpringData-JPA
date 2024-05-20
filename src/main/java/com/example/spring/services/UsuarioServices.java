package com.example.spring.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.entities.Telefone;
import com.example.spring.entities.UsuarioSpring;
import com.example.spring.repositories.UsuarioRepository;

@Service
public class UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional()
    public List<Telefone> getTelefonesDeUsuario(Long usuarioId) {
        
        UsuarioSpring usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        List<Telefone> telefones = usuario.getListaTelefone();
        return new ArrayList<>(telefones);
    }
}
