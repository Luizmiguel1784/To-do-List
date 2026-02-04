package com.List.To_Do.service;

import com.List.To_Do.Repository.TarefaRepository;
import com.List.To_Do.Repository.UsuarioRepository;
import com.List.To_Do.dto.TarefaDTO;
import com.List.To_Do.entities.Tarefa;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;


    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public TarefaDTO criartarefa (TarefaDTO dto){

        Tarefa task = new Tarefa(dto);
        tarefaRepository.save(task);
        TarefaDTO Tdto = new TarefaDTO(task);
        return Tdto;
    }

}
