package com.tarefa01.tarefa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping

public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/saudacao/{nome}_{sobrenome}")
    public String saudacao(@PathVariable String nome, @PathVariable String sobrenome, ModelMap model) {
        model.addAttribute("nome", nome);
        model.addAttribute("sobrenome", sobrenome);
        return "saudacao";
    }

    @GetMapping("/media/{prova1}/{prova2}")
    public String media(@PathVariable String prova1, @PathVariable String prova2, ModelMap model) {
        model.addAttribute("prova1", prova1);
        model.addAttribute("prova2", prova2);

        //Fazendo a transformação dos Tipos, convertendo a String em Double (com o ParseDouble)
        Double prova1Double = Double.parseDouble(prova1);
        Double prova2Double = Double.parseDouble(prova2);
        Double media = (prova1Double + prova2Double)/2;

        //Formatando o Resultado da MEDIA para ter 2 casas decimais e Atribuindo o MEDIA para ser exibido
        String mediaFormatado = String.format("%.2f", media);
        model.addAttribute("mediaFormatado", mediaFormatado);

        //Criando a variavel que armazenará a Classificação da media
        String classificacaoMedia = "";

        //Lógica para definição da Classificação
        if (media >= 6) {
            classificacaoMedia = "Está a cima da média";
        } else {
            classificacaoMedia = "Está a baixo da média";
        }

        //Atribuindo a Classificação de acordo com o IMC para poder ser exibido
        model.addAttribute("classificacaoMedia", classificacaoMedia);

        return "media";
    }

    @GetMapping("/imc/peso={peso}&altura={altura}")
    public String imc(@PathVariable String peso, @PathVariable String altura, ModelMap model) {
        //Obtendo o Peso e Altura pela Rota
        model.addAttribute("peso", peso);
        model.addAttribute("altura", altura);

        //Fazendo a transformação dos Tipos, convertendo a String (passada pela URL) em Double (com o ParseDouble)
        Double pesoTipoDouble = Double.parseDouble(peso);
        Double alturaTipoDouble = Double.parseDouble(altura);
        Double imc = pesoTipoDouble / Math.pow(alturaTipoDouble, 2);

        //Formatando o Resultado do IMC para ter 2 casas decimais e Atribuindo o IMC para ser exibido
        String imcFormatado = String.format("%.2f", imc);
        model.addAttribute("imcFormatado", imcFormatado);

        //Criando a variavel que armazenará a Classificação do IMC
        String classificacaoDoImc = "";

        //Lógica para definição da Classificação
        if (imc < 18.5) {
            classificacaoDoImc = "Abaixo do peso";
        } else if (imc >= 18.5 && imc <= 24.9) {
            classificacaoDoImc = "Normal";
        } else if (imc >= 25 && imc <= 29.9) {
            classificacaoDoImc = "Possível sobrepeso";
        } else if (imc >= 30 && imc <= 34.9) {
            classificacaoDoImc = "Obesidade grau I";
        } else if (imc >= 35 && imc <= 39.9) {
            classificacaoDoImc = "Obesidade grau II";
        } else {
            classificacaoDoImc = "Obesidade mórbida";
        }

        //Atribuindo a Classificação de acordo com o IMC para poder ser exibido
        model.addAttribute("classificacaoDoImc", classificacaoDoImc);

        return "imc";
    }

}