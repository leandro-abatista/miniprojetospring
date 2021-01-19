package br.com.arfaxtec.mps.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arfaxtec.mps.entities.Categoria;


public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{
	
	
}
