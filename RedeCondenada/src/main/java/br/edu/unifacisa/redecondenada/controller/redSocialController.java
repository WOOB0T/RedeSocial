package br.edu.unifacisa.redecondenada.controller;


import br.edu.unifacisa.redecondenada.Service.CookieService;
import br.edu.unifacisa.redecondenada.model.Conta;
import br.edu.unifacisa.redecondenada.model.Postagens;
import br.edu.unifacisa.redecondenada.repository.ContaRepository;
import br.edu.unifacisa.redecondenada.repository.PostsRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class redSocialController {

    private ContaRepository contaRepository;
    private PostsRepository postsRepository;

    public redSocialController() {
    }

    @Autowired
    public redSocialController(ContaRepository contaRepository, PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
        this.contaRepository = contaRepository;
    }
    @GetMapping()
    public String index() {
        return "index"; // nome do arquivo que será chamado
    }

    @GetMapping("/login")
    public String telaDeLogin(Model model) {
        model.addAttribute("Conta", new Conta());
        return "index";
    }

    @PostMapping("/logar")
    public String logar(@ModelAttribute Conta credenciais, Model model, HttpServletResponse response) {
        Conta verificarConta = this.contaRepository.Entrar(credenciais.getUsuario(), credenciais.getSenha());
        if (verificarConta != null) {
            CookieService.setCookie(response, "userId", String.valueOf(credenciais.getId()),9999999);
            model.addAttribute("error", null);
            return "redirect:/posts";
        }
        model.addAttribute("error", "Credenciais erradas");
        return "posts";
    }

    @GetMapping("/registrar")
    public String showRegisterForm(Model model) {
        model.addAttribute("Conta", new Conta());
        return "index";
    }

    @PostMapping("/registrar")
    public String cadastrarConta(@ModelAttribute Conta novoUsuario, Model model){
        Conta novaConta = this.contaRepository.verificacaoDeConta(novoUsuario.getUsuario());
        if (novaConta == null) {
            contaRepository.save(novoUsuario);
        } else{
            model.addAttribute("usuarioExistente", "Esse nome de Usuario ja Existe.");
        }
        return "index";
    }

    @GetMapping("/posts")
    public String feedDePostagens(Model model, HttpServletResponse response){
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");

        model.addAttribute("postagens", postsRepository.findAll());
        return "posts";
    }

    @GetMapping("/newpost")
    public String novoPost(Model model){
        model.addAttribute("postagem", new Postagens());
        return "newpost";
    }

    @PostMapping("/novaPostagem")
    public String novaPostagem(@ModelAttribute Postagens newPost, Model model, HttpServletRequest request){
        model.addAttribute("post", newPost);
        String userId = CookieService.getCookie(request, "userId");
        if (userId != null) {
            Optional<Conta> user = contaRepository.findById(Integer.parseInt(userId));
            if(user.isPresent()) {
                newPost.setUser(user.get());
                postsRepository.save(newPost);
                return "redirect:/posts";
            }
        }
        return "post";
    }

    @GetMapping("/exit")
    public String logout(HttpServletResponse response) {
        CookieService.setCookie(response, "userId", "", 0);
        return "redirect:/login";
    }

    @GetMapping("/testes")
    public String testes(){
        return "testes";
    }

}