package br.com.arfaxtec.mps.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.arfaxtec.mps.entities.enums.OrdemServicoStatus;

@Entity
public class OrdemServico implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momentoDoPedido;
	
	private Integer ordemServicoStatus;

	@ManyToOne
	@JoinColumn(name = "clienteId")
	private Usuario cliente;

	public OrdemServico() {

	}

	public OrdemServico(Long id, Instant momentoDoPedido, OrdemServicoStatus ordemServicoStatus, Usuario cliente) {
		super();
		this.id = id;
		this.momentoDoPedido = momentoDoPedido;
		setOrdemServicoStatus(ordemServicoStatus);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomentoDoPedido() {
		return momentoDoPedido;
	}

	public void setMomentoDoPedido(Instant momentoDoPedido) {
		this.momentoDoPedido = momentoDoPedido;
	}

	public Usuario getCliente() {
		return cliente;
	}
	
	public OrdemServicoStatus getOrdemServicoStatus() {
		return OrdemServicoStatus.valueOff(ordemServicoStatus);
	}
	
	public void setOrdemServicoStatus(OrdemServicoStatus ordemServicoStatus) {
		if (ordemServicoStatus != null) {
			this.ordemServicoStatus = ordemServicoStatus.getCodigo();
		}
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
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
		OrdemServico other = (OrdemServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
