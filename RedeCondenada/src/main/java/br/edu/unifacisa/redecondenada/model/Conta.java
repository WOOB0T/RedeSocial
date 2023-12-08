package br.edu.unifacisa.redecondenada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Conta {

    @Id
    public String user;
    public String email;
    public String senha;

}
