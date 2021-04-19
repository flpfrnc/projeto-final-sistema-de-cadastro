package bti.ufrn.imd.assets;

public class Produto {
	private String codigoProduto;
	private String nomeProduto;
	protected double precoUnitario;
	
	public Produto(String codigo, String nome, double preco) {
		this.codigoProduto = codigo;
		this.nomeProduto = nome;
		this.precoUnitario = preco;
	}
	
	public String getCodigo() {
		return this.codigoProduto;
	}

	public void setCodigo(String codigo) {
		this.codigoProduto = codigo;
	}
	  
	public String getNome() {
		return this.nomeProduto;
	}

	public void setNome(String nome) {
		this.nomeProduto = nome;
	}
	
	public double getPreco() {
		return this.precoUnitario;
	}
	
	public void setPreco(double preco) {
		this.precoUnitario = preco;
	}
	
	public String toString() {
		String retorno = "Produto: " + this.nomeProduto;
		retorno += "\nCodigo: " + this.codigoProduto;
		retorno += "\nPre�o: R$ " + this.precoUnitario;		
		return retorno;
	}
	
	@Override
    public boolean equals(Object other) {
		if (other == null || !other.getClass().equals(Produto.class)) {
			return false;
		}
		Produto otherProduto = (Produto) other;
		return otherProduto.codigoProduto.equals(this.codigoProduto);
    }

    public int hashCode(){
      return this.codigoProduto.hashCode();
    }
}
