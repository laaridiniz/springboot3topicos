package br.gov.sp.fatec.springboot3topicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3topicos.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
