package br.edu.unifacisa.redecondenada.controller;


import br.edu.unifacisa.redecondenada.model.Conta;
import br.edu.unifacisa.redecondenada.repository.ContaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class redSocialController {

    private ContaRepository repository;

    @GetMapping()
    public String index() {
        return "index"; // nome do arquivo que será chamado
    }

    @GetMapping("/login")
    public String telaDeLogin() {
        return "login";
    }

    @PostMapping()
    public String EntrarNaConta(@ModelAttribute Conta EntrarNaConta, Model model) {
        Conta nomeDeUsuario = this.repository.Entrar(EntrarNaConta.getNomeDeUsuario(), EntrarNaConta.getSenha());
        if (nomeDeUsuario != null) {
            model.addAttribute("error", null);
            return "redirect:/home";
        }
        model.addAttribute("error", "wrong password or username");
        return "index";
    }
}