package bti.ufrn.imd.assets;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Operacao extends Loja {
	
	private String cpf, cnpj;
	
	public Operacao(String cpf, String cnpj, Loja loja, Pix pix, Credito credito, Debito debito, Boleto boleto, Map<Produto, Integer> carrinho) {
		super();
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.pix = new Pix(loja);
  		this.credito = new Credito(loja);
  		this.debito = new Debito(loja);
  		this.boleto = new Boleto(loja);
	}
	
	public void iniciaOperacao() {
		System.out.println("\nSelecione os produtos: ");
    	System.out.println("\n");
    	
    	Iterator<Produto> ProdutoAsIterator = super.getVendedor(cnpj).getCatalogo().iterator();
        while (ProdutoAsIterator.hasNext()){
        	Produto it = ProdutoAsIterator.next();
        	System.out.println(it);
        	System.out.println("\n");
        } 
        
        System.out.println("\nDigite o código do produto:");
        Scanner escolha = new Scanner(System.in);
        String codigoEscolha = escolha.nextLine();
        
        Iterator<Produto> Produtos = super.getVendedor(cnpj).getCatalogo().iterator();
        while (Produtos.hasNext()){
        	Produto it = Produtos.next();
        	if(it.getCodigo().equals(codigoEscolha)) {
        		if(this.carrinho.get(it) == null) {
        			this.carrinho.put(it, 1);
        		}else {
        			this.carrinho.put(it, this.carrinho.get(it)+1);
        		}
        		super.total += it.precoUnitario;
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
        		this.pix.pagamento(cpf, cnpj);        		
        	}else if(pagamento.equals("Boleto")) {
        		this.boleto.pagamento(cpf, cnpj);
        	}else if(pagamento.equals("Debito")) {
        		this.debito.pagamento(cpf, cnpj);
        	}else if(pagamento.equals("Credito")) {
        		this.credito.pagamento(cpf, cnpj);
        	}else {
        		System.out.println("Método de pagamento inválido!");
        	}
        }else {
        	this.iniciaOperacao();
        }
	}
	
}
