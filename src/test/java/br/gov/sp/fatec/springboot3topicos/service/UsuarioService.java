package br.gov.sp.fatec.springboot3topicos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3topicos.entity.Usuario;
import br.gov.sp.fatec.springboot3topicos.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    public List<Usuario> buscarTodosUsuarios() {
        List<Usuario> usuarios = usuarioRepo.findAll();
        return usuarios;
    }

    public Usuario cadastraUsuario(Usuario usuario) {
        if(usuario == null ||
                usuario.getNome() == null ||
                usuario.getNome().isBlank() ||
                usuario.getSenha() == null ||
                usuario.getSenha().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        return usuarioRepo.save(usuario);
    }

    public Usuario buscarUsuarioPorId(Long id) {
        Optional<Usuario> usuarioOp = usuarioRepo.findById(id);
        if(usuarioOp.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!");
        }
        return usuarioOp.get();
    }

}