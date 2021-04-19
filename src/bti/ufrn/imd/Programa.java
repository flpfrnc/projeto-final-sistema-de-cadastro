package bti.ufrn.imd;

import bti.ufrn.imd.assets.*;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {		
		//Nao foi implementada funcionalidade para adicionar novo cliente e vendedor atraves do Scanner
		Comprador cliente1 = new Comprador("Joao", "111.222.333-45", 0.00, 0.00, 0);
		Comprador cliente2 = new Comprador("Maria", "111.222.444-45", 0.00, 0.00, 0);
		Vendedor vendedor1 = new Vendedor("Joseph", "111.222.555-45", 2745.00, 0.00, 0);
		Vendedor vendedor2 = new Vendedor("Raphael", "111.222.666-45", 2745.00, 0.00, 0);
		//Loja nesse contexto contem os registros dos clientes e vendedores
		Loja registro = new Loja();
		
		registro.registraComprador(cliente1, 2975);
		registro.registraComprador(cliente2, 2470);
		registro.registraVendedor(vendedor1);
		registro.registraVendedor(vendedor2);
		registro.getPix().getLoja().getVendedor("111.222.555-45").setSaldo(registro.getPix().getLoja().getVendedor("111.222.555-45").getSaldo() + 1);
		System.out.println(registro.getPix().getLoja().getVendedor("111.222.555-45").getSaldo());
		
		//
		System.out.println("\n0- Sair; \n1 ~ 9- Acessar escolhas:");
		Scanner escolha = new Scanner(System.in);	
		String opcao = escolha.nextLine();
		while(!opcao.equals("0")) {
			System.out.println("\n1- Imprimir dados cliente;\n2- Imprimir dados vendedor;"
					+ "\n3- Registrar produto;\n4- Comprar/Vender;\n5 ~ 0- Sair;");
			String menu = escolha.nextLine();
			if(menu.equals("1")) {
				System.out.println("\nDigitar CPF do cliente: ");
				String cpf = escolha.nextLine();
				registro.getComprador(cpf);
			}else if(menu.equals("2")) {
				System.out.println("\nDigitar CNPJ do Vendedor: ");
				String cnpj = escolha.nextLine();
				registro.getVendedor(cnpj);
			}else if(menu.equals("3")) {
				System.out.println("\nDigitar CNPJ do Vendedor: ");
				String cnpj = escolha.nextLine();
				registro.adicionaProduto(cnpj);
			}else if(menu.equals("4")) {
				System.out.println("\nDigitar CPF do cliente: ");
				String cpf = escolha.nextLine();
				System.out.println("\nDigitar CNPJ do Vendedor: ");
				String cnpj = escolha.nextLine();
				registro.operacao(cpf, cnpj);
			}else {
				System.out.println("Saindo...");
				break;
			}
		}
	}
}