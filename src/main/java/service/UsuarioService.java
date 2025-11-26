package service;

import Repository.UsuarioRepository;
import com.List.To_Do.dto.UsuarioDTO;
import entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.data.projection.EntityProjection.ProjectionType.DTO;

public class UsuarioService {



    private final  usuarioRepository usuarioRepository;

    public UsuarioService(usuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDTO criarUsuario(UsuarioDTO dto) {

        Usuario user = new Usuario(dto);
        usuarioRepository.save(user);
        UsuarioDTO udto = new UsuarioDTO(user);
        return udto;
    }
}
