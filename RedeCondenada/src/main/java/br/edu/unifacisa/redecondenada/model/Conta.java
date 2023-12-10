package br.edu.unifacisa.redecondenada.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    private String usuario;
    private String senha;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Postagens> postagens;

    public List<Postagens> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Postagens> postagens) {
        this.postagens = postagens;
    }

    public Conta(){
        this.postagens = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
