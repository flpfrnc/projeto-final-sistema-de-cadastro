package bti.ufrn.imd.assets;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Operacao extends Loja {
	
	private String cpf, cnpj;
	
	public Operacao(String cpf, String cnpj, iniciaPagamento pagamentos, Pix pix, Debito debito, Credito credito, Boleto boleto, Map<Produto, Integer> carrinho) {
		super();
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.pagamentos = pagamentos;
		super.pix = pix;
		super.debito = debito;
		super.credito = credito;
		super.boleto = boleto;
	}
	
	public void iniciaOperacao() {
		System.out.println("\nSelecione os produtos: ");
    	System.out.println("\n");
    	
    	Iterator<Produto> ProdutoAsIterator = super.pagamentos.getLoja().getVendedor(cnpj).getCatalogo().iterator();
        while (ProdutoAsIterator.hasNext()){
        	Produto it = ProdutoAsIterator.next();
        	System.out.println(it);
        	System.out.println("\n");
        } 
        
        System.out.println("\nDigite o c�digo do produto:");
        Scanner escolha = new Scanner(System.in);
        String codigoEscolha = escolha.nextLine();
        
        Iterator<Produto> Produtos = super.pagamentos.getLoja().getVendedor(cnpj).getCatalogo().iterator();
        while (Produtos.hasNext()){
        	Produto it = Produtos.next();
        	if(it.getCodigo().equals(codigoEscolha)) {
        		if(this.carrinho.get(it) == null) {
        			super.carrinho.put(it, 1);
        		}else {
        			super.carrinho.put(it, super.carrinho.get(it)+1);
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
        		super.pix.pagamento(cpf, cnpj);        		
        	} else if(pagamento.equals("Boleto")) {
        		super.boleto.pagamento(cpf, cnpj);
        	} else if(pagamento.equals("Debito")) {
        		super.debito.pagamento(cpf, cnpj);
        	} else if(pagamento.equals("Credito")) {
        		super.credito.pagamento(cpf, cnpj);
        	} else {
        		System.out.println("M�todo de pagamento inv�lido!");
        	}
        } else {
        	this.iniciaOperacao();
        }
	}
}
