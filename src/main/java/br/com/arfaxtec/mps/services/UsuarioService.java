package br.com.arfaxtec.mps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arfaxtec.mps.entities.Usuario;
import br.com.arfaxtec.mps.repositorios.UsuarioRepositorio;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	public List<Usuario> findAll() {
		return usuarioRepositorio.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> obj = usuarioRepositorio.findById(id);
		return obj.get();
	}

}
