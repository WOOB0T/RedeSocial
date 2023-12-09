package br.edu.unifacisa.redecondenada.repository;

import br.edu.unifacisa.redecondenada.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContaRepository extends JpaRepository<Conta, Integer>{
    @Query(value= "select * from Conta where usuario = :usuario and senha = :senha", nativeQuery = true)
    public Conta Entrar(String usuario, String senha);
}
