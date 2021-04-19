package bti.ufrn.imd.assets;

public class Pessoa {
	
	private String nome;
	protected double saldo;
	
	public Pessoa(String nome, double saldo) {
		this.nome = nome;
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void increSaldo(double saldo) {
		this.saldo += saldo;
	}
	
	public void decreSaldo(double saldo) {
		this.saldo -= saldo;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
