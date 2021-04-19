package bti.ufrn.imd.assets;

public enum MenuEnum {
	DIGITAR_CPF_CLIENTE(1, "Imprimir dados do Cliente"),
	DIGITAR_CNPJ_VENDEDOR(2, "Digitar CNPJ do Vendedor"),
	REGISTRAR_PRODUTO(3, "Registrar Produto"),
	COMPRAR_VENDER(4, "Comprar/Vender");
	
	private final int value;
	private final String message;
	
	private MenuEnum(int value, String message) {
		this.value = value;
		this.message = message;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getMessage() {
		return message;
	}
}
