package com.List.To_Do.Controller;


import com.List.To_Do.dto.UsuarioRequest;
import com.List.To_Do.dto.UsuarioResponse;
import org.springframework.web.bind.annotation.*;
import com.List.To_Do.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){

        this.usuarioService = usuarioService;
    }

    @PostMapping("/Usuarios")
    public UsuarioResponse criarUsuario(@RequestBody UsuarioRequest request){
        return usuarioService.criarUsuario(request);
    }
    @GetMapping("/Usuarios")
     public List<UsuarioResponse> listarUsuarios(){
        return usuarioService.listarUsuarios();
     }
     @GetMapping("/{id}")
    public UsuarioResponse buscarPorId(@PathVariable Integer id){
        return usuarioService.buscarPorId(id);
     }
      @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Integer id){
        usuarioService.deletarUsuario(id);
      }


}
