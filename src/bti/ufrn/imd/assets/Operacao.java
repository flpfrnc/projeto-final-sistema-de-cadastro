package bti.ufrn.imd.assets;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Operacao extends Loja {
	
	private String cpf, cnpj;
	
	
	public Operacao(String cpf, String cnpj, IniciaPagamento pagamentos, Map<Produto, Integer> carrinho, double total) {
		super();
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.pagamentos = pagamentos;
	}
	
	public void iniciaOperacao() {
		System.out.println("\nSelecione os produtos: \n");
    	
    	Iterator<Produto> ListaProdutos = this.pagamentos.getLoja().getVendedor(cnpj).getCatalogo().iterator();
        while (ListaProdutos.hasNext()){
        	Produto item = ListaProdutos.next();
        	System.out.println(item);
        	System.out.println("\n");
        } 
        
        System.out.println("\nDigite o código do produto:");
        Scanner escolhaProduto = new Scanner(System.in);
        String codigoEscolha = escolhaProduto.nextLine();
        
        Iterator<Produto> ProdutosCarrinho = this.pagamentos.getLoja().getVendedor(cnpj).getCatalogo().iterator();
        while (ProdutosCarrinho.hasNext()){
        	Produto item = ProdutosCarrinho.next();
        	if(item.getCodigo().equals(codigoEscolha)) {
        		if(this.carrinho.get(item) == null) {
        			this.carrinho.put(item, 1);
        		}else {
        			this.carrinho.put(item, this.carrinho.get(item)+1);
        		}
        		this.total += item.precoUnitario;
        	}
        }
        System.out.println("\nProdutos no carrinho:");
        System.out.println(carrinho);
        this.otherOperacao();
	}
	
	//OBS: Adicionar novo enum para esse menu de operações
	public void otherOperacao() {
		Scanner escolhaOperacao = new Scanner(System.in);		
		System.out.println("\nAdicionar mais produtos?");
        String addMais = escolhaOperacao.nextLine();
        
        if(addMais.equals("N") || addMais.equals("n")) {
        	System.out.println("Compra finalizada!!!");
        	System.out.println("\nEscolha a forma de pagamento: ");
        	
        	String pagamento = escolhaOperacao.nextLine();
        	if(pagamento.equals("Pix")) {
        		this.pix = new Pix(this.pagamentos.getLoja(), this.total);
        		this.pix.pagamento(cpf, cnpj); 
        		this.pagamentos.getLoja().getComprador(this.cpf).comprasRealizadas++;
        		this.pagamentos.getLoja().getVendedor(this.cnpj).vendasRealizadas++;
        		
        	}else if(pagamento.equals("Boleto")) {
        		this.boleto = new Boleto(this.pagamentos.getLoja(), this.total);
        		this.boleto.pagamento(cpf, cnpj);
        		this.pagamentos.getLoja().getComprador(this.cpf).comprasRealizadas++;
        		this.pagamentos.getLoja().getVendedor(this.cnpj).vendasRealizadas++;
        		
        	}else if(pagamento.equals("Debito")) {
        		this.debito = new Debito(this.pagamentos.getLoja(), this.total);
        		this.debito.pagamento(cpf, cnpj); 
        		this.pagamentos.getLoja().getComprador(this.cpf).comprasRealizadas++;
        		this.pagamentos.getLoja().getVendedor(this.cnpj).vendasRealizadas++;
        		
        	}else if(pagamento.equals("Credito")) {
        		this.credito = new Credito(this.pagamentos.getLoja(), this.total);
        		this.credito.pagamento(cpf, cnpj); 
        		this.pagamentos.getLoja().getComprador(this.cpf).comprasRealizadas++;
        		this.pagamentos.getLoja().getVendedor(this.cnpj).vendasRealizadas++;
        	}else {
        		System.out.println("Método de pagamento inválido!");
        		
        	}
        }else {
        	this.iniciaOperacao();
        }
	}
}
