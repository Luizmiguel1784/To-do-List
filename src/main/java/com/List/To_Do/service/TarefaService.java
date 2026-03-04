package com.List.To_Do.service;

import com.List.To_Do.Repository.TarefaRepository;
import com.List.To_Do.Repository.UsuarioRepository;
import com.List.To_Do.dto.TarefaRequest;
import com.List.To_Do.dto.TarefaResponse;
import com.List.To_Do.dto.UsuarioRequest;
import com.List.To_Do.entities.Status;
import com.List.To_Do.entities.Tarefa;
import com.List.To_Do.entities.Usuario;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;
    private final UsuarioRepository usuarioRepository;

    public TarefaService(TarefaRepository tarefaRepository, UsuarioRepository usuarioRepository) {
        this.tarefaRepository = tarefaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public TarefaResponse criarTarefa(Integer usuarioId, TarefaRequest tarefaRequest) {

        Usuario usuarioExistente = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));



    Tarefa tarefa = new Tarefa();
    tarefa.setNome(tarefaRequest.getNome());
    tarefa.setDescricao(tarefaRequest.getDescricao());
    tarefa.setDtInicio(tarefaRequest.getDtInicio());
    tarefa.setDtFim(tarefaRequest.getDtFim());
    tarefa.setStatus(Status.PENDENTE);
    tarefa.setUsuario(usuarioExistente);
    tarefaRepository.save(tarefa);

     TarefaResponse tarefaResponse = new TarefaResponse(
             tarefa.getId(),
             tarefa.getNome(),
             tarefa.getDescricao(),
             tarefa.getStatus(),
             tarefa.getDtInicio(),
             tarefa.getDtFim()

     );       return tarefaResponse;

    }


}