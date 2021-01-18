package br.com.arfaxtec.mps.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arfaxtec.mps.entities.OrdemServico;


public interface OSRepositorio extends JpaRepository<OrdemServico, Long>{
	
	
}
