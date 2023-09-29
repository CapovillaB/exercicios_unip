package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Aluno;
import com.model.AlunoService;

@Controller
public class AlunoController {

    private AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;

    }

    @RequestMapping("/listaAlunos")
    public ModelAndView listarAlunos(@ModelAttribute("aluno") Aluno aluno) {

        try {
            ModelAndView modelAndView = new ModelAndView("alunos");
            modelAndView.addObject("listaDeAlunos", alunoService.listarAlunos());

            return modelAndView;
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView("erro");

            System.out.println("erro");

            return modelAndView;
        }

    }

    @PostMapping("/salvaAluno")
    public String salvarAluno(@ModelAttribute("aluno") Aluno aluno) {
        Aluno alunoTemp = alunoService.findAluno(aluno.getMatricula());
        if (alunoTemp != null) {
            int idAlunoTemp = alunoService.listarAlunos().indexOf(alunoTemp);
            alunoService.listarAlunos().set(idAlunoTemp, aluno);
        } else
            alunoService.listarAlunos().add(aluno);

        return "redirect:/listaAlunos";
    }

    @RequestMapping("/selecionaAluno")
    public ModelAndView selecionarAlunos(@RequestParam("id") int matricula) {
        Aluno aluno = alunoService.findAluno(matricula);
        ModelAndView modelAndView = new ModelAndView("alunos");
        modelAndView.addObject("listaDeAlunos", alunoService.listarAlunos());
        modelAndView.addObject("aluno", aluno);
        return modelAndView;
    }

    @RequestMapping("/removeAluno")
    public String removerAluno(@RequestParam("id") int matricula) {
        Aluno alunoTemp = alunoService.findAluno(matricula);
        if (alunoTemp != null) {
            int idAlunoTemp = alunoService.listarAlunos().indexOf(alunoTemp);
            alunoService.listarAlunos().remove(idAlunoTemp);
        }
        return "redirect:/listaAlunos";
    }
}
