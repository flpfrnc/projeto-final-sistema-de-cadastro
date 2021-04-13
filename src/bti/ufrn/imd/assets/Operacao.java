package bti.ufrn.imd.assets;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Operacao extends Loja {
	
	private String cpf, cnpj;
	
	public Operacao(String cpf, String cnpj, FormaPagamento formaPagamento, Map<Produto, Integer> carrinho) {
		super();
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.formaPagamento = formaPagamento;
	}
	
	public void iniciaOperacao() {
		System.out.println("\nSelecione os produtos: ");
    	System.out.println("\n");
    	
    	Iterator<Produto> ProdutoAsIterator = this.formaPagamento.getLoja().getVendedor(cnpj).getCatalogo().iterator();
        while (ProdutoAsIterator.hasNext()){
        	Produto it = ProdutoAsIterator.next();
        	System.out.println(it);
        	System.out.println("\n");
        } 
        
        System.out.println("\nDigite o código do produto:");
        Scanner escolha = new Scanner(System.in);
        String codigoEscolha = escolha.nextLine();
        
        Iterator<Produto> Produtos = this.formaPagamento.getLoja().getVendedor(cnpj).getCatalogo().iterator();
        while (Produtos.hasNext()){
        	Produto it = Produtos.next();
        	if(it.getCodigo().equals(codigoEscolha)) {
        		if(this.carrinho.get(it) == null) {
        			this.carrinho.put(it, 1);
        		}else {
        			this.carrinho.put(it, this.carrinho.get(it)+1);
        		}
        		this.formaPagamento.getLoja().total += it.precoUnitario;
        	}
        }
        System.out.println("\nProdutos no carrinho:");
        System.out.println(carrinho);
        
        this.otherOperacao();
	}
	
	public void otherOperacao() {
		Scanner escolha = new Scanner(System.in);		
		System.out.println("\nAdicionar mais produtos?");
        String addMais = escolha.nextLine();
        
        if(addMais.equals("N") || addMais.equals("n")) {
        	System.out.println("Compra finalizada!!!");
        	System.out.println("\nEscolha a forma de pagamento: ");
        	
        	String pagamento = escolha.nextLine();
        	if(pagamento.equals("Pix")) {
        		this.formaPagamento.Pix(cpf, cnpj);        		
        	}else if(pagamento.equals("Boleto")) {
        		this.formaPagamento.Boleto(cpf, cnpj);
        	}else if(pagamento.equals("Debito")) {
        		this.formaPagamento.Debito(cpf, cnpj);
        	}else if(pagamento.equals("Credito")) {
        		this.formaPagamento.Credito(cpf, cnpj);
        	}else {
        		System.out.println("Método de pagamento inválido!");
        	}
        }else {
        	this.iniciaOperacao();
        }
	}
	
}
