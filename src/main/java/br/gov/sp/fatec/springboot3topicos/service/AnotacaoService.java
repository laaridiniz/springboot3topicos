package br.gov.sp.fatec.springboot3topicos.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3topicos.entity.Anotacao;
import br.gov.sp.fatec.springboot3topicos.entity.Usuario;
import br.gov.sp.fatec.springboot3topicos.repository.AnotacaoRopository;
import br.gov.sp.fatec.springboot3topicos.repository.UsuarioRepository;

@Service
public class AnotacaoService {

    @Autowired
    private AnotacaoRopository anotacaoRepo;

    @Autowired
    private UsuarioService usuarioServ;

    public Anotacao nova(Anotacao anotacao) {
        if(anotacao == null ||
        anotacao.getTexto() == null ||
        anotacao.getTexto().isBlanck() ||
        anotacao.getUsuario() == null ||
        anotacao.getUsuario().getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos.");
        }
        if(anotacao.getDataHora() == null){
            anotacao.setDataHora(LocalDateTime.now());
        }
        Usuario usuario = usuarioServ.buscarUsuarioPorId(anotacao.getUsuario().getId());
        anotacao.setUsuario(usuario);
        return anotacaoRepo.save(anotacao);
    }

    public List<Anotacao> buscarTodas(){
        return anotacaoRepo.findAll();
    }
}
