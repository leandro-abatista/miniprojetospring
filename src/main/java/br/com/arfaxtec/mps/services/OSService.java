package br.com.arfaxtec.mps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arfaxtec.mps.entities.OrdemServico;
import br.com.arfaxtec.mps.repositorios.OSRepositorio;

@Service
public class OSService {

	@Autowired
	private OSRepositorio osRepositorio;

	public List<OrdemServico> findAll() {
		return osRepositorio.findAll();
	}

	public OrdemServico findById(Long id) {
		Optional<OrdemServico> obj = osRepositorio.findById(id);
		return obj.get();
	}

}
