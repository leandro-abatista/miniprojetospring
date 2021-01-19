package br.com.arfaxtec.mps.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arfaxtec.mps.entities.Produto;


public interface ProdutoRepositorio extends JpaRepository<Produto, Long>{
	
	
}
