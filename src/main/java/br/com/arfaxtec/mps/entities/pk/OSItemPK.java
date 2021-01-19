package br.com.arfaxtec.mps.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.arfaxtec.mps.entities.OrdemServico;
import br.com.arfaxtec.mps.entities.Produto;
/**
 * Classe auxiliar de chave composta
 * 
 *
 */
@Embeddable
public class OSItemPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "OS_id")
	private OrdemServico ordemServico;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ordemServico == null) ? 0 : ordemServico.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OSItemPK other = (OSItemPK) obj;
		if (ordemServico == null) {
			if (other.ordemServico != null)
				return false;
		} else if (!ordemServico.equals(other.ordemServico))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}

}
