package bti.ufrn.imd.assets;

public class Pix extends FormaPagamento {
	
	public Pix(Loja loja) {
		super(loja);
	}
	
	@Override
	public void pagamento(String cpf, String cnpj) {
		this.getLoja().getComprador(cpf).setSaldo(this.getLoja().getComprador(cpf).saldo -= this.getLoja().getTotal());
		this.getLoja().getVendedor(cnpj).saldo += this.getLoja().getTotal();
	}
	
}
