package br.com.arfaxtec.mps.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arfaxtec.mps.entities.Usuario;


public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	
	
}
