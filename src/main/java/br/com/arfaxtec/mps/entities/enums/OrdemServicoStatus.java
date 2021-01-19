package br.com.arfaxtec.mps.entities.enums;

public enum OrdemServicoStatus {
	
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int codigo;
	
	private OrdemServicoStatus(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static OrdemServicoStatus valueOff(int codigo) {
		for (OrdemServicoStatus value : OrdemServicoStatus.values()) {
			if (value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código do Status da Ordem de Serviço é inválido!");
	}

}
