package br.com.arfaxtec.mps.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.arfaxtec.mps.entities.Categoria;
import br.com.arfaxtec.mps.entities.OSItem;
import br.com.arfaxtec.mps.entities.OrdemServico;
import br.com.arfaxtec.mps.entities.Produto;
import br.com.arfaxtec.mps.entities.Usuario;
import br.com.arfaxtec.mps.entities.enums.OrdemServicoStatus;
import br.com.arfaxtec.mps.repositorios.CategoriaRepositorio;
import br.com.arfaxtec.mps.repositorios.OSItemRepositorio;
import br.com.arfaxtec.mps.repositorios.OSRepositorio;
import br.com.arfaxtec.mps.repositorios.ProdutoRepositorio;
import br.com.arfaxtec.mps.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private OSRepositorio oSRepositorio;
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	private OSItemRepositorio oSItemRepositorio;

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");
		Categoria cat4 = new Categoria(null, "Roupas");
		Categoria cat5 = new Categoria(null, "Calçados");
		Categoria cat6 = new Categoria(null, "Fashion");
		
		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoriaRepositorio.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));
		produtoRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		/*associação entre objeto - produto e categoria*/
		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);
		
		produtoRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		
		
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		OrdemServico o1 = new OrdemServico(null, Instant.parse("2019-06-20T19:53:07Z"), OrdemServicoStatus.PAGO, u1);
		OrdemServico o2 = new OrdemServico(null, Instant.parse("2019-07-21T03:42:10Z"), OrdemServicoStatus.AGUARDANDO_PAGAMENTO, u2);
		OrdemServico o3 = new OrdemServico(null, Instant.parse("2019-07-22T15:21:22Z"), OrdemServicoStatus.ENVIADO, u1);
		
		usuarioRepositorio.saveAll(Arrays.asList(u1, u2));
		oSRepositorio.saveAll(Arrays.asList(o1, o2, o3));
		
		
		OSItem osi1 = new OSItem(o1, p1, 2, p1.getValor());
		OSItem osi2 = new OSItem(o1, p3, 1, p3.getValor());
		OSItem osi3 = new OSItem(o2, p3, 2, p3.getValor());
		OSItem osi4 = new OSItem(o3, p5, 2, p5.getValor());
		
		oSItemRepositorio.saveAll(Arrays.asList(osi1, osi2, osi3, osi4));
		
		
	}
}
