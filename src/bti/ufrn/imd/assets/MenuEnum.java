package bti.ufrn.imd.assets;

public enum MenuEnum {
	IMPRIMIR_DADOS_CLIENTE(1, "Imprimir dados do Cliente;"),
	IMPRIMIR_DADOS_VENDEDOR(2, "Digitar CNPJ do Vendedor;"),
	REGISTRAR_PRODUTO(3, "Registrar Produto;"),
	COMPRAR_VENDER_PRODUTO(4, "Comprar/Vender;"),
	FECHAR_PROGRAMA(5, "Digite 5 ou 0 para sair...");
	
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
