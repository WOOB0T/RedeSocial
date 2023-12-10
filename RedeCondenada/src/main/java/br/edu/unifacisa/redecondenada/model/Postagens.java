package br.edu.unifacisa.redecondenada.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Postagens{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String conteudo;
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Conta usuario;

    public Conta getUsuario() {
        return usuario;
    }

    public void setUsuario(Conta autor) {
        this.usuario = autor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
