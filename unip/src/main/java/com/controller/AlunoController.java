package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Aluno;
import com.model.AlunoDAO;


@Controller
public class AlunoController {
    private AlunoDAO alunoDAO;

    @Autowired
    public AlunoController(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    @RequestMapping("/listaAlunos")
    public ModelAndView listarAlunos(@ModelAttribute("aluno") Aluno aluno) {
        ModelAndView modelAndView = new ModelAndView("alunos");
        modelAndView.addObject("listaDeAlunos", alunoDAO.listarAlunos());
        return modelAndView;
    }

    @PostMapping("/salvaAluno")
    public String salvarAluno(@ModelAttribute("aluno") Aluno aluno) {
        Aluno alunoTemp = alunoDAO.pesquisarAluno(aluno.getMatricula());
        if (alunoTemp != null) {
            alunoDAO.alterarAluno(aluno);
        } else
            alunoDAO.incluirAluno(aluno);
        return "redirect:/listaAlunos";
    }

    @RequestMapping("/selecionaAluno")
    public ModelAndView selecionarAlunos(@RequestParam("id") int matricula) {
        System.out.println("buscando o aluno: " + matricula);
        Aluno aluno = alunoDAO.pesquisarAluno(matricula);
        ModelAndView modelAndView = new ModelAndView("alunos");
        modelAndView.addObject("listaDeAlunos", alunoDAO.listarAlunos());
        modelAndView.addObject("aluno", aluno);
        return modelAndView;
    }

    @RequestMapping("/removeAluno")
    public String removerAluno(@RequestParam("id") int matricula) {
        alunoDAO.excluirAluno(matricula);
        return "redirect:/listaAlunos";
    }
}
