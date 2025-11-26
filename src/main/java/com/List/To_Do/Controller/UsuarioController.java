package com.List.To_Do.Controller;


import com.List.To_Do.dto.UsuarioDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    public UsuarioController(UsuarioService usuarioService){

        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<?> criarUsuario(@Valid @RequestBody UsuarioDTO dto){

        return ResponseEntity.ok(usuarioService.criarUsurio(dto));
    }
}
