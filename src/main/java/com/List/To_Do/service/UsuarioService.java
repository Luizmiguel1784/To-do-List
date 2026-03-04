package com.List.To_Do.service;

import com.List.To_Do.Repository.UsuarioRepository;
import com.List.To_Do.dto.UsuarioRequest;
import com.List.To_Do.dto.UsuarioResponse;
import com.List.To_Do.entities.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final  UsuarioRepository usuarioRepository;


    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    public UsuarioResponse criarUsuario(UsuarioRequest usuarioRequest){

        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuarioRequest.getEmail());

        if (usuarioExistente.isPresent()){

            throw new RuntimeException("email ja cadastrado");
        }


        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequest.getNome());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setSenha(usuarioRequest.getSenha());
        usuarioRepository.save(usuario);

        UsuarioResponse usuarioResponse = new UsuarioResponse(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getNome()
                ); return usuarioResponse;
        
    }

    //Get
    public List<UsuarioResponse> listarUsuarios(){

        //Busca o usuario
        List<Usuario> usuarios = usuarioRepository.findAll();

        //Retorna o usuario
        return usuarios.stream()
                .map(usuario -> new UsuarioResponse(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getNome()
        )).toList();
    }
    //Get by Id
    public UsuarioResponse buscarPorId(Integer id){

        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        return new UsuarioResponse(
                    usuario.getId(),
                    usuario.getEmail(),
                    usuario.getNome()
        );

    }

    //Delete
    public void deletarUsuario(Integer id){

        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        usuarioRepository.delete(usuario);
    }
}
