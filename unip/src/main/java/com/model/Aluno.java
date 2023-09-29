package com.model;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    private int matricula;

    @Getter
    @Setter
    private String nome;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Getter
    @Setter
    private Date dataNascimento;

    public Aluno(String nome, Date dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
}