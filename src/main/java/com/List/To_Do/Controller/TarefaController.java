package com.List.To_Do.Controller;

import com.List.To_Do.service.TarefaService;
import com.List.To_Do.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produto")
public class TarefaController {

    private final TarefaService tarefaService;

        public TarefaController(TarefaService tarefaService){
            this.tarefaService = tarefaService;
        }


}
