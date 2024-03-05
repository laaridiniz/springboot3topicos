package br.gov.sp.fatec.springboot3topicos.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UsuarioService {
    
    public Usuario cadastraUsuario(Usuario usuario) {
        if(usuario == null ||
        usuario.getNome() == null ||
        usuario.getNome().isBlanck() ||
        usuario.getSenha() == null ||
        usuario.getSenha().isBlanck()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao cadastrar usuário.");
        }
        if(!usuario.getAutorizacoes().isEmpty()){
            Set<Autorizacao> autorizacoes = new HashSet<Autorizacao>();
            for(Autorizacao)
        }
        return usuarioRepo.save(usuario);
    }
}
