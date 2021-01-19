package br.com.arfaxtec.mps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arfaxtec.mps.entities.Produto;
import br.com.arfaxtec.mps.repositorios.ProdutoRepositorio;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	public List<Produto> findAll() {
		return produtoRepositorio.findAll();
	}

	public Produto findById(Long id) {
		Optional<Produto> obj = produtoRepositorio.findById(id);
		return obj.get();
	}

}
