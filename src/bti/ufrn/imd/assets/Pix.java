package bti.ufrn.imd.assets;

public class Pix extends FormaPagamento{
	
	public Pix(Loja loja) {
		super(loja);
	}
	
	@Override
	public void pagamento(String cpf, String cnpj) {
		super.getLoja().getComprador(cpf).saldo -= super.getLoja().total;
		super.getLoja().getVendedor(cnpj).saldo += super.getLoja().total;
	}
	
}
