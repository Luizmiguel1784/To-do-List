package com.List.To_Do.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Entity
public class Tarefa {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String nome;
    private String descricao;
    private Status status;
    private LocalDate dtInicio;
    private LocalDate dtFim;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


}
