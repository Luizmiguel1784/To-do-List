package com.List.To_Do.Controller;

import com.List.To_Do.dto.TarefaRequest;
import com.List.To_Do.dto.TarefaResponse;
import com.List.To_Do.service.TarefaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class TarefaController {

    private final TarefaService tarefaService;

        public TarefaController(TarefaService tarefaService) {
            this.tarefaService = tarefaService;}

    @PostMapping("/usuarios/{usuarioid}/tarefa")
    public TarefaResponse criarTarefa(@PathVariable Integer usuarioid,  @RequestBody TarefaRequest request){
          return tarefaService.criarTarefa(usuarioid, request);
        }

    @GetMapping("/usuarios/{usuarioid}/tarefas")
    public List<TarefaResponse> listarTarefas(@PathVariable Integer usuarioid){
            return tarefaService.listarTarefa(usuarioid);

    }
    @PutMapping("/usuarios/{usuarioid}/tarefas")
    public TarefaResponse atualizarTarefa(@PathVariable Integer usuarioid,  @RequestBody TarefaRequest request){
            return tarefaService.atualizarTarefa(usuarioid, request);
    }

    @DeleteMapping("/usuarios/{usuarioid}/tarefas")
    public void deletarTarefa(@PathVariable Integer usuarioid){


            tarefaService.deletarTarefa(usuarioid);
    }
    
}
