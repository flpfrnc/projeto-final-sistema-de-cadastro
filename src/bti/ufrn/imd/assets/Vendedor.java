package bti.ufrn.imd.assets;

import java.util.Set;
import java.util.HashSet;

public class Vendedor extends Pessoa{
	private String cnpjVendedor;
	protected double valoresReceber;
	protected int vendasRealizadas;
	private Set<Produto> catalogoProdutos;
	
	public Vendedor(String nome, String cnpj, double saldo, double receber, int vendas) {
		super(nome, saldo);
		this.cnpjVendedor = cnpj;
		this.valoresReceber = receber;
		this.vendasRealizadas = vendas;
		this.catalogoProdutos = new HashSet<>();
	}
	
	public void setCnpj(String cnpj) {
		this.cnpjVendedor = cnpj;
	}
	
	public String getCnpj() {
		return this.cnpjVendedor;
	}
	
	public Set<Produto> getCatalogo(){
		return this.catalogoProdutos;
	}
	
	public void addProduto(Produto produto) {
		this.catalogoProdutos.add(produto);
	}
	
	public void removeProduto(Produto produto) {
		this.catalogoProdutos.remove(produto);
	}
	
	public String toString() {
		String retorno = "Nome Vendedor: " + this.getNome();
		retorno += "\nCNPJ: " + this.cnpjVendedor;
		retorno += "\nSaldo: R$ " + this.saldo;
		retorno += "\nValor a receber: R$ " + this.valoresReceber;		
		retorno += "\nVendas: " + this.vendasRealizadas;
		retorno += "\nProdutos: " + this.catalogoProdutos;	
		return retorno;
	}
	
	@Override
    public boolean equals(Object other){
		if (other == null || !other.getClass().equals(Vendedor.class)) {
			return false;
		}
		Vendedor otherVendedor = (Vendedor) other;
		return otherVendedor.getNome().equals(this.getNome());
    }

    public int hashCode(){
      return this.cnpjVendedor.hashCode();
    }
}
