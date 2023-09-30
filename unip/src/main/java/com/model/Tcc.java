package com.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import lombok.*;


@Entity
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor public class Tcc { 
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int codigo; 
    private String titulo; 
    private int ano; 
    private int semestre; 
    
    @OneToMany(mappedBy = "tcc", cascade = CascadeType.ALL) 
    private List<Aluno> alunosGrupo = new ArrayList<>(); 
    
    public Tcc(String titulo, int ano, int semestre, List<Aluno> alunosGrupo) { 
        this.titulo = titulo; this.ano = ano; 
        this.semestre = semestre; 
        this.alunosGrupo = alunosGrupo; 
    } 
}
