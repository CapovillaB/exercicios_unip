package com.model;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricula;
    private String nome;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;
    @ManyToOne
    @JoinColumn(name = "tcc_codigo")
    private Tcc tcc;

    public Aluno(int matricula, String nome, Date dataNascimento) {
        this.matricula = matricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Aluno(String nome, Date dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
}