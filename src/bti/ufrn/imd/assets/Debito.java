package bti.ufrn.imd.assets;

public class Debito extends FormaPagamento {
	
	private double taxaPercentual = 0.074;
	
	public Debito(Loja loja) {
		super(loja);
	}

	@Override
	public void pagamento(String cpf, String cnpj) {
		super.getLoja().getComprador(cpf).saldo -= super.getLoja().total;
		super.getLoja().getVendedor(cnpj).saldo += super.getLoja().total - (super.getLoja().total * this.taxaPercentual);
	}

}
