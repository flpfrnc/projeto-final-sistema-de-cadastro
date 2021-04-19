package bti.ufrn.imd;

import bti.ufrn.imd.assets.*;

import java.io.IOException;
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
		
		System.out.println("\n1 ~ 4- Acessar menu; \n0- Sair;\n");
		
		Scanner escolha = new Scanner(System.in);	
		String opcao = escolha.nextLine();		  
		while(!opcao.equals("0")) {
			String cpf;
			String cnpj;
			
			System.out.println(	"\n1- " + MenuEnum.IMPRIMIR_DADOS_CLIENTE.getMessage() + "\n" + 
								"2- " + MenuEnum.IMPRIMIR_DADOS_VENDEDOR.getMessage() + "\n" +
								"3- " + MenuEnum.REGISTRAR_PRODUTO.getMessage() + "\n" + 
								"4- " + MenuEnum.COMPRAR_VENDER_PRODUTO.getMessage() + "\n" + 
								"5 ou 0- " + MenuEnum.FECHAR_PROGRAMA.getMessage());

			String menu = escolha.nextLine();
			
			switch(menu) {
				case "1":
					System.out.println("\nDigitar CPF do cliente: ");
					cpf = escolha.nextLine();
					registro.printComprador(cpf);
					break;
				case "2": 
					System.out.println("\nDigitar CNPJ do Vendedor: ");
					cnpj = escolha.nextLine();
					registro.printVendedor(cnpj);
					break;
				case "3": 
					System.out.println("\nDigitar CNPJ do Vendedor: ");
					cnpj = escolha.nextLine();
					registro.adicionaProduto(cnpj);
					break;
				case "4":
					System.out.println("\nDigitar CPF do cliente: ");
					cpf = escolha.nextLine();
					System.out.println("\nDigitar CNPJ do Vendedor: ");
					cnpj = escolha.nextLine();
					registro.operacao(cpf, cnpj);
					break;
				case "5":
					System.exit(0);
				default:
					System.exit(0);
			}
		}
	}
}