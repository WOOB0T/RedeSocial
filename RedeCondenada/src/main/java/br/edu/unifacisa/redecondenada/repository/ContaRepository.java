package br.edu.unifacisa.redecondenada.repository;

import br.edu.unifacisa.redecondenada.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContaRepository extends JpaRepository<Conta, String>{
    @Query(value = "select * from Conta where nomeDeUsuario = :nomeDeUsuario and senha = :senha", nativeQuery = true)
    public Conta Entrar(String nomeDeUsuario, String senha);
}
