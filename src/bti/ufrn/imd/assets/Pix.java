package bti.ufrn.imd.assets;

public class Pix extends FormaPagamento{

	public Pix(Loja loja, double total) {
		super(loja);
		this.getLoja().setTotal(total);
	}
	
	@Override
	public void pagamento(String cpf, String cnpj) {
		System.out.println("Total atual: " + super.getLoja().getTotal());
		this.getLoja().getComprador(cpf).decreSaldo(this.getLoja().getTotal());
		this.getLoja().getVendedor(cnpj).increSaldo(this.getLoja().getTotal());
	}
	
}
