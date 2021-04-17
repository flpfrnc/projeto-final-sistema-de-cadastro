package bti.ufrn.imd.assets;

abstract class FormaPagamento {
	private Loja loja;
	
	public FormaPagamento(Loja loja){
		this.loja = loja;
	}
	
	public Loja getLoja() {
		return this.loja;
	}
	
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	
	public abstract void pagamento(String cpf, String cnpj);
	
}
