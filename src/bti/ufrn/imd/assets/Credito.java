package bti.ufrn.imd.assets;

public class Credito extends FormaPagamento{

	private double taxaPercentual = 0.074;
	
	public Credito(Loja loja) {
		super(loja);
	}

	@Override
	public void pagamento(String cpf, String cnpj) {
		super.getLoja().getComprador(cpf).valoresPagamento += super.getLoja().total;
		super.getLoja().getVendedor(cnpj).valoresReceber += super.getLoja().total - (super.getLoja().total * this.taxaPercentual);
	}

}
