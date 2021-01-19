package br.com.arfaxtec.mps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arfaxtec.mps.entities.Categoria;
import br.com.arfaxtec.mps.repositorios.CategoriaRepositorio;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	public List<Categoria> findAll() {
		return categoriaRepositorio.findAll();
	}

	public Categoria findById(Long id) {
		Optional<Categoria> obj = categoriaRepositorio.findById(id);
		return obj.get();
	}

}
