package br.com.arfaxtec.mps.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.arfaxtec.mps.entities.pk.OSItemPK;

@Entity
public class OSItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OSItemPK id = new OSItemPK();
	
	private Integer quantidade;
	private Double preco;

	public OSItem() {

	}

	public OSItem(OrdemServico ordemServico, Produto produto,Integer quantidade, Double preco) {
		id.setOrdemServico(ordemServico);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	@JsonIgnore
	public OrdemServico getOrdemServico() {
		return id.getOrdemServico();
	}
	
	public void setOrdemServico(OrdemServico ordemServico) {
		id.setOrdemServico(ordemServico);
	}
	
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		OSItem other = (OSItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
