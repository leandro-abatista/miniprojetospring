package br.com.arfaxtec.mps.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arfaxtec.mps.entities.OSItem;


public interface OSItemRepositorio extends JpaRepository<OSItem, Long>{
	
	
}
