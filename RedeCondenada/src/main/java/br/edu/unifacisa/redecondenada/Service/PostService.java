package br.edu.unifacisa.redecondenada.Service;

import br.edu.unifacisa.redecondenada.model.Postagens;
import br.edu.unifacisa.redecondenada.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostsRepository postagensRepository;

    public List<Postagens> listarPostagens() {
        return postagensRepository.findAllByOrderByDataDesc();
    }
}