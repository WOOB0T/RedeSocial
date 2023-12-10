package br.edu.unifacisa.redecondenada.controller;


import br.edu.unifacisa.redecondenada.model.Conta;
import br.edu.unifacisa.redecondenada.model.Postagens;
import br.edu.unifacisa.redecondenada.repository.ContaRepository;
import br.edu.unifacisa.redecondenada.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class redSocialController {

    @Autowired
    private ContaRepository contaRepository;
    
    private PostsRepository postsRepository;

    public redSocialController(ContaRepository contaRepository, PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
        this.contaRepository = contaRepository;
    }
    @GetMapping()
    public String index() {
        return "index"; // nome do arquivo que será chamado
    }

    @GetMapping("/login")
    public String telaDeLogin() {
        return "index";
    }

    @PostMapping("/logar")
    public String logar(@ModelAttribute Conta credenciais, Model model) {
        Conta verificarConta = this.contaRepository.Entrar(credenciais.getUsuario(), credenciais.getSenha());
        if (verificarConta != null) {
            model.addAttribute("error", null);
            return "redirect:/posts";
        }
        model.addAttribute("error", "Credenciais erradas");
        return "index";
    }

    @RequestMapping("/registrar")
    public String RegisterUsers(@ModelAttribute Conta credenciais, Model model){
        contaRepository.save(credenciais);
        return "index";
    }

    @GetMapping("/posts")
    public String feedDePostagens(Model model){
        model.addAttribute("postagens", postsRepository.findAll());
        return "posts";
    }

    @PostMapping("/newpost")
    public String novaPostagem(@ModelAttribute Postagens newPost, Model model){
        postsRepository.save(newPost);
        return "posts";
    }


}