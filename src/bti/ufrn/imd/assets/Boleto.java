package bti.ufrn.imd.assets;

import java.time.LocalDate;
import java.util.Scanner;

public class Boleto extends FormaPagamento{
	
	private LocalDate dataBoleto;
	private LocalDate dataAtual;
	private double valorEmissao = 3.00;
	
	public Boleto(Loja loja, double total) {
		super(loja);
		this.getLoja().setTotal(total);
	}
	
	public void setDataBoleto(int dia, int mes, int ano) {
		this.dataBoleto = LocalDate.of(ano, mes, dia);
	}
	
	@Override
	public void pagamento(String cpf, String cnpj) {
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
			this.getLoja().getComprador(cpf).decreSaldo(this.getLoja().getTotal());
			this.getLoja().getVendedor(cnpj).increValoresRcb(this.getLoja().getTotal() - this.valorEmissao);
		}
		data.close();
	}
}
