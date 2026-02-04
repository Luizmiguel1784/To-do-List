package com.List.To_Do.service;

import com.List.To_Do.Repository.TarefaRepository;
import com.List.To_Do.Repository.UsuarioRepository;
import com.List.To_Do.dto.TarefaDTO;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;


    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public TarefaDTO criartarefa (){

    }

}
