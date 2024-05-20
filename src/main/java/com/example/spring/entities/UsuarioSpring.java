package com.example.spring.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.*;

@Entity
public class UsuarioSpring {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String senha;
    private String email;
    private int login;

    @OneToMany(mappedBy = "usuarioSpring")
    private List<Telefone> listaTelefone = new ArrayList<>();

    public UsuarioSpring(String nome, String senha, String email, int login) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.login = login;
    }

    public UsuarioSpring() {
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public List<Telefone> getListaTelefone() {
        return listaTelefone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UsuarioSpring other = (UsuarioSpring) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
