package bti.ufrn.imd.assets;

public enum OperacaoEnum {
	PIX("Pix"),
	BOLETO("Boleto"),
	DEBITO("Debito"),
	CREDITO("Credito");
	
	private final String message;
	
	private OperacaoEnum(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
