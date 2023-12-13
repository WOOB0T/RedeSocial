package br.edu.unifacisa.redecondenada.repository;

import br.edu.unifacisa.redecondenada.model.Postagens;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Postagens, Integer> {

    List<Postagens> findAllByOrderByDataDesc();
//    List<Postagens> findAllByUserContaOrderByDataDesc(String username);

}