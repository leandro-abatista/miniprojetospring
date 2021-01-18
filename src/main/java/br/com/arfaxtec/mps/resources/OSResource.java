package br.com.arfaxtec.mps.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arfaxtec.mps.entities.OrdemServico;
import br.com.arfaxtec.mps.services.OSService;

@RestController
@RequestMapping(value = "/ordensDeServico")
public class OSResource {
	
	@Autowired
	private OSService osService;
	
	@GetMapping
	public ResponseEntity<List<OrdemServico>> findAll(){
		List<OrdemServico> list = osService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrdemServico> findById(@PathVariable Long id){
		OrdemServico obj = osService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
