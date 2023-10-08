package com.unip.universidade.model.bd;

import java.util.List;

import com.unip.universidade.model.Aluno;

public interface AlunoDAO {
    public List<Aluno> listarAlunos();
    public boolean inserirAluno(Aluno aluno);
}
