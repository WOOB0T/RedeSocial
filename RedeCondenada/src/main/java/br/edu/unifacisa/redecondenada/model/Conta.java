package br.edu.unifacisa.redecondenada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public String NomeDeUsuario;
    public String senha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeDeUsuario() {
        return NomeDeUsuario;
    }

    public void setNomeDeUsuario(String nomeDeUsuario) {
        this.NomeDeUsuario = nomeDeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
