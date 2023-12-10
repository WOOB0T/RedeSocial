package br.edu.unifacisa.redecondenada.repository;

import br.edu.unifacisa.redecondenada.model.Conta;
import br.edu.unifacisa.redecondenada.model.Postagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostsRepository extends JpaRepository<Postagens, Integer> {


}