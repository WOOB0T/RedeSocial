package br.edu.unifacisa.redecondenada.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Postagens{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String conteudo;
    private LocalDateTime data;

    @ManyToOne
    private Conta user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @PrePersist
    protected void onCreate() {
        data = LocalDateTime.now();
    }

    public Conta getUser() {
        return user;
    }

    public void setUser(Conta user) {
        this.user = user;
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

    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return data.format(formatter);
    }
}
