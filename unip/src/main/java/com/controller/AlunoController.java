package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Aluno;

import com.model.bd.AlunoRepository;

@Controller
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @RequestMapping("/listaAlunos")
    public ModelAndView listarAlunos(@ModelAttribute("aluno") Aluno aluno) {
        ModelAndView modelAndView = new ModelAndView("alunos");
        modelAndView.addObject("listaDeAlunos", alunoRepository.findAll());
        return modelAndView;
    }

    @RequestMapping("/selecionaAluno")
    public ModelAndView selecionarAlunos(@RequestParam("id") int matricula) {
        System.out.println("buscando o aluno: " + matricula);
        Aluno aluno = alunoRepository.findById(Integer.valueOf(matricula)).get();
        ModelAndView modelAndView = new ModelAndView("alunos");
        modelAndView.addObject("listaDeAlunos", alunoRepository.findAll());
        modelAndView.addObject("aluno", aluno);
        return modelAndView;
    }

    @PostMapping("/salvaAluno")
    public String salvarAluno(@ModelAttribute("aluno") Aluno aluno) {
        alunoRepository.save(aluno);
        return "redirect:/listaAlunos";
    }

    @RequestMapping("/removeAluno")
    public String removerAluno(@RequestParam("id") int matricula) {

        return "redirect:/listaAlunos";
    }
}
