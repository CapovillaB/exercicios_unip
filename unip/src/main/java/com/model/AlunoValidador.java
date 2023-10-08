package com.model;

import java.util.GregorianCalendar;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AlunoValidador implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Aluno.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Aluno aluno = (Aluno) obj;
        if (aluno.getNome().isEmpty())
            errors.rejectValue("nome", "nome.vazio");
        if (aluno.getDataNascimento() == null)
            errors.rejectValue("dataNascimento", "nascimento.nulo");
        else {
            if (aluno.getDataNascimento().after(new GregorianCalendar(2005, 12, 31).getTime()))
                errors.rejectValue("dataNascimento", "nascimento.menor");
        }
    }
}