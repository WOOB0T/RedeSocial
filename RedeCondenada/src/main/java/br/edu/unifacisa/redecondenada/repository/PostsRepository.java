package br.edu.unifacisa.redecondenada.repository;

import br.edu.unifacisa.redecondenada.model.Postagens;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

public interface PostsRepository extends JpaRepository<Postagens, Integer> {

    // public List<Postagens> findAllByUserOrderByDataDesc(String username);

    public List<Postagens> findAllByOrderByDataDesc();


}
