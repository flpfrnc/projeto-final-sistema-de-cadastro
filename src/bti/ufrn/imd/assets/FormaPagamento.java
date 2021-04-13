package bti.ufrn.imd.assets;

import java.time.LocalDate;
import java.util.Scanner;

public class FormaPagamento {
	
	private Loja loja;
	private double taxaPercentual = 0.074;
	private double valorEmissao = 3.00;
	private LocalDate dataBoleto;
	private LocalDate dataAtual;
	
	
	public FormaPagamento(Loja loja){
		this.loja = loja;
		this.dataAtual = LocalDate.now();
	}
	
	public void Pix(String cpf, String cnpj) {		
		this.loja.getComprador(cpf).saldo -= this.loja.total;
		this.loja.getVendedor(cnpj).saldo += this.loja.total;
	}
	
	public void Boleto(String cpf, String cnpj) {
		Scanner data = new Scanner(System.in);
		
		System.out.println("Digite o dia referente ao vencimento do boleto: ");
        int dia = data.nextInt();
        System.out.println("Digite o mes referente ao vencimento do boleto: ");
        int mes = data.nextInt();
        System.out.println("Digite o ano referente ao vencimento do boleto: ");
        int ano = data.nextInt();
        
		this.setDataBoleto(dia, mes, ano);
		if(this.dataAtual.isAfter(dataBoleto)) {
			System.out.println("Boleto Vencido!");
		}else {
			this.loja.getComprador(cpf).saldo -= this.loja.total;
			this.loja.getVendedor(cnpj).valoresReceber += (this.loja.total - this.valorEmissao);
		}
	}
	
	public void Debito(String cpf, String cnpj) {		
		this.loja.getComprador(cpf).saldo -= this.loja.total;
		this.loja.getVendedor(cnpj).saldo += this.loja.total - (this.loja.total * this.taxaPercentual);
	}
	
	public void Credito(String cpf, String cnpj) {		
		this.loja.getComprador(cpf).valoresPagamento += this.loja.total;
		this.loja.getVendedor(cnpj).valoresReceber += this.loja.total - (this.loja.total * this.taxaPercentual);
	}
	
	public Loja getLoja() {
		return this.loja;
	}
	
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	
	public void setDataBoleto(int dia, int mes, int ano) {
		this.dataBoleto = LocalDate.of(ano, mes, dia);
	}
	
}
