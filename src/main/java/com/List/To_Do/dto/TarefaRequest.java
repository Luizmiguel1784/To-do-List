package com.List.To_Do.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TarefaRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;

    private LocalDate dtInicio;
    private LocalDate dtFim;




    
}
