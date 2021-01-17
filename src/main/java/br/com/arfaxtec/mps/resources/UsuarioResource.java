package br.com.arfaxtec.mps.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arfaxtec.mps.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarioResource")
public class UsuarioResource {
	
	@GetMapping
	public ResponseEntity<Usuario> findAll(){
		Usuario u = new Usuario(1L, "Maria", "maria@gmail.com", "99999999", "123");
		return ResponseEntity.ok().body(u);
	}
}
