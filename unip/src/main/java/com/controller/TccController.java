package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.model.*;
import com.model.bd.*;
import jakarta.transaction.*;


@Controller
@SessionAttributes({"listaAlunos", "listaTcc"})
public class TccController {

    @Autowired
    private TccRepository tccRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/tcc")
    public ModelAndView listaTcc() {
        ModelAndView modelAndView = new ModelAndView("tcc");
        modelAndView.addObject("tcc", new Tcc());
        modelAndView.addObject("listaTcc", tccRepository.findAll());
        modelAndView.addObject("listaAlunos", alunoRepository.findAll());
        return modelAndView;
    }

    @PostMapping("/cadastroTcc")
    @Transactional
    public String cadastro(@Valid @ModelAttribute("tcc") Tcc pTcc, Errors errors) {
        System.out.println("chamou o cadastro");
        if (errors.hasErrors())
            return "tcc";

        Tcc tcc = new Tcc(pTcc.getTitulo(), pTcc.getAno(), pTcc.getSemestre(), pTcc.getAlunosGrupo());
        for (Aluno a : tcc.getAlunosGrupo()) {
            a.setTcc(tcc);
            alunoRepository.save(a);
        }
        tccRepository.save(tcc);
        return "redirect:/tcc";
    }
}