package br.edu.unifacisa.redecondenada.controller;


import br.edu.unifacisa.redecondenada.model.Conta;
import br.edu.unifacisa.redecondenada.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class redSocialController {

    @Autowired
    private ContaRepository repository;
    public redSocialController(ContaRepository repository) {
        this.repository = repository;
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
        Conta verificarConta = this.repository.Entrar(credenciais.getUsuario(), credenciais.getSenha());
        if (verificarConta != null) {
            model.addAttribute("error", null);
            return "redirect:/posts";
        }
        model.addAttribute("error", "Credenciais erradas");
        return "index";
    }

    @RequestMapping("/registrar")
    public String RegisterUsers(@ModelAttribute Conta credenciais, Model model){
        repository.save(credenciais);
        return "index";
    }

    @GetMapping("/userlist")
    public String ListUsers(Model model){
        model.addAttribute("socialUser", repository.findAll());
        return "userlist";
    }

    @GetMapping("/posts")
    public String feedDePostagens(){
        return "posts";
    }

}