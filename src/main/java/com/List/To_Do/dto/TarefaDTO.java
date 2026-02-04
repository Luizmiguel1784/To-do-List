package com.List.To_Do.dto;

import com.List.To_Do.entities.Status;
import com.List.To_Do.entities.Tarefa;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class TarefaDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    private Status status;
    private LocalDate dtInicio;
    private LocalDate dtFim;

    public TarefaDTO(String descricao, String nome, Status status, LocalDate dtInicio, LocalDate dtFim) {
        this.descricao = descricao;
        this.nome = nome;
        this.status = status;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
    }

    public TarefaDTO(Tarefa task) {
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao( String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(LocalDate dtInicio) {
        this.dtInicio = dtInicio;
    }

    public LocalDate getDtFim() {
        return dtFim;
    }

    public void setDtFim(LocalDate dtFim) {
        this.dtFim = dtFim;
    }
}
