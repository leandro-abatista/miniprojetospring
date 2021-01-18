package br.com.arfaxtec.mps.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.arfaxtec.mps.entities.OrdemServico;
import br.com.arfaxtec.mps.entities.Usuario;
import br.com.arfaxtec.mps.repositorios.OSRepositorio;
import br.com.arfaxtec.mps.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private OSRepositorio oSRepositorio;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		OrdemServico o1 = new OrdemServico(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		OrdemServico o2 = new OrdemServico(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		OrdemServico o3 = new OrdemServico(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		
		usuarioRepositorio.saveAll(Arrays.asList(u1, u2));
		oSRepositorio.saveAll(Arrays.asList(o1, o2, o3));
		
	}
}
