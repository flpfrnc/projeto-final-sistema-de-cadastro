package bti.ufrn.imd.assets;

public class Debito extends FormaPagamento {
	
	private double taxaPercentual = 0.074;
	
	public Debito(Loja loja, double total) {
		super(loja);
		this.getLoja().setTotal(total);
	}

	@Override
	public void pagamento(String cpf, String cnpj) {
		this.getLoja().getComprador(cpf).decreSaldo(this.getLoja().getTotal());
		this.getLoja().getVendedor(cnpj).increSaldo(this.getLoja().getTotal() - (this.getLoja().getTotal() * this.taxaPercentual));
	}

}
