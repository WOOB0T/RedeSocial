package br.edu.unifacisa.redecondenada.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class redSocialController {

    @GetMapping()
    public String index() {

        return "index"; // nome do arquivo que será chamado
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }



}
