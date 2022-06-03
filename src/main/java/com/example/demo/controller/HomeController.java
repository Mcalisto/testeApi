package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Cadastro;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(ModelMap model) {
        model.addAttribute("nomeDoAtributo", "Treinaweb");

        return "home";
    }
    
    @GetMapping(path="/")
    public String addCadastro(Model model) {
        model.addAttribute("cadastro", new Cadastro());
        
        return "addCadastro";
    }
    
    @GetMapping(path="/source")
    public String sourceCode(Model model) {
           
        return "sourceCode";
    }

}