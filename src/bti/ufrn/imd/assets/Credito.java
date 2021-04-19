package bti.ufrn.imd.assets;

public class Credito extends FormaPagamento{

	private double taxaPercentual = 0.074;
	
	public Credito(Loja loja, double total) {
		super(loja);
		this.getLoja().setTotal(total);
	}

	@Override
	public void pagamento(String cpf, String cnpj) {
		this.getLoja().getComprador(cpf).increValoresPg(this.getLoja().getTotal());
		this.getLoja().getVendedor(cnpj).increValoresRcb(this.getLoja().getTotal() - (this.getLoja().getTotal() * this.taxaPercentual));
	}

}
