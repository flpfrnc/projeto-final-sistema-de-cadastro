package bti.ufrn.imd.assets;

public class Comprador extends Pessoa {
	private String cpfComprador;
	protected double valoresPagamento;
	protected int comprasRealizadas;
	
	public Comprador(String nome, String cpf, double saldo, double pagamento, int compras) {
		super(nome, saldo);
		this.cpfComprador = cpf;
		this.valoresPagamento = pagamento;
		this.comprasRealizadas = compras;
	}
	
	public String getCpf() {
		return this.cpfComprador;
	}
	
	public void setCpf(String cpf) {
		this.cpfComprador = cpf;
	}
	
	
	public double getValoresPg() {
		return this.valoresPagamento;
	}
	
	public int getCompras() {
		return this.comprasRealizadas;
	}
	
	public String toString() {
		String retorno = "Nome Comprador: " + this.getNome();
		retorno += "\nSaldo: R$ " + this.getSaldo();
		retorno += "\nValor a pagar: R$ " + this.valoresPagamento;		
		retorno += "\nCompras: " + this.comprasRealizadas;	
		return retorno;
	}
	
	@Override
    public boolean equals(Object other){
		if (other == null || !other.getClass().equals(Comprador.class)) {
			return false;
		}
		Comprador otherComprador = (Comprador) other;
		return otherComprador.cpfComprador.equals(this.cpfComprador);
    }

    public int hashCode(){
      return this.cpfComprador.hashCode();
    }
}
