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

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

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
             tarefa.getTarefaid(),
             tarefa.getNome(),
             tarefa.getDescricao(),
             tarefa.getStatus(),
             tarefa.getDtInicio(),
             tarefa.getDtFim()

     );       return tarefaResponse;

    }


    public  List<TarefaResponse> listarTarefa(Integer usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(()-> new RuntimeException("Usuario não encontrado"));

        List<Tarefa> tarefas = usuario.getTarefas();

        return  tarefas.stream().map(tarefa -> new TarefaResponse(
                tarefa.getTarefaid(),
                tarefa.getNome(),
                tarefa.getDescricao(),
                tarefa.getStatus(),
                tarefa.getDtInicio(),
                tarefa.getDtFim()
        )).toList();

    }



    public TarefaResponse atualizarTarefa(Integer id, TarefaRequest request) {

        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuario não encontrado"));

        tarefa.setNome(request.getNome());
        tarefa.setDescricao(request.getDescricao());
        tarefa.setDtInicio(request.getDtInicio());
        tarefa.setDtFim(request.getDtFim());
        tarefaRepository.save(tarefa);

        return new TarefaResponse(
                tarefa.getTarefaid() ,
                tarefa.getNome(),
                tarefa.getDescricao(),
                tarefa.getStatus(),
                tarefa.getDtInicio(),
                tarefa.getDtFim()
        );

    }

    public void deletarTarefa(Integer tarefaId) {

        Tarefa tarefa = tarefaRepository.findById(tarefaId)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        tarefaRepository.delete(tarefa);
    }


}