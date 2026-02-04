package com.List.To_Do.service;

import com.List.To_Do.Repository.UsuarioRepository;
import com.List.To_Do.dto.UsuarioDTO;
import com.List.To_Do.entities.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class UsuarioService {

    private final  UsuarioRepository usuarioRepository;


    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public UsuarioDTO criarUsuario(UsuarioDTO dto) {

        Usuario user = new Usuario(dto);
        usuarioRepository.save(user);
        UsuarioDTO udto = new UsuarioDTO(user);
        return udto;
    }




}
