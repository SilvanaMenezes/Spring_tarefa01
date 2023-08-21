package com.tarefa01.tarefa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping

public class HomeController{

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/saudacao/{nome}_{sobrenome}")
    public String saudacao(@PathVariable String nome, @PathVariable String sobrenome, ModelMap model){
        model.addAttribute("nome",nome);
        model.addAttribute("sobrenome",sobrenome);
        return "saudacao";
    }

    @GetMapping("/media")
    public String media(){
        return "media";
    }

    @GetMapping("/imc")
    public String imc(){
        return "imc";
    }

}