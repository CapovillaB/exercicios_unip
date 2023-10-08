package com.unip.universidade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.unip.universidade.model.Aluno;
import com.unip.universidade.model.bd.AlunoDAO;

/*@RestController
public class AlunoController {
    @Autowired
    private AlunoDAO alunoDAO;

    @GetMapping("/testeLista")
    public String listarAlunos() {
        List<Aluno> alunos = alunoDAO.listarAlunos();
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getMatricula() + " " + aluno.getNome() + " " + aluno.getDataNascimento());
        }
        return "ok";
    }
}*/

@Controller
public class AlunoController {
    @Autowired
    private AlunoDAO alunoDAO;

    @GetMapping("/testeLista")
    public ModelAndView listarAlunos() {
        List<Aluno> alunos = alunoDAO.listarAlunos();
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getMatricula() + " " + aluno.getNome() + " " + aluno.getDataNascimento());
        }

        ModelAndView mAv = new ModelAndView("aluno");
        mAv.addObject("listaDeAlunos", alunos);
        mAv.addObject("aluno", new Aluno());
        return mAv;
    }

    @PostMapping("/aluno")
    public String adicionarAluno(@ModelAttribute("aluno") Aluno aluno) {
        if (alunoDAO.inserirAluno(aluno))
            System.out.println("Novo aluno incluído com sucesso!");
        return "redirect:/testeLista";
    }


}
