package br.edu.unifacisa.redecondenada.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Postagens {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String conteudo;
    private Date data;

    @ManyToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Conta autor;

    public Conta getAutor() {
        return autor;
    }

    public void setAutor(Conta autor) {
        this.autor = autor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
