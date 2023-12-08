package br.edu.unifacisa.redecondenada.repository;

import br.edu.unifacisa.redecondenada.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, String>{
}
