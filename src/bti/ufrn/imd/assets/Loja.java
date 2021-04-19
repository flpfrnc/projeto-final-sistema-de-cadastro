package bti.ufrn.imd.assets;

import java.util.Scanner;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class Loja {
	private Set<Comprador> cadastroComprador;
	private Set<Vendedor> cadastroVendedor;
	private Comprador dadosComprador;
	private Vendedor dadosVendedor;
	protected Pix pix;
	protected Credito credito;
	protected Debito debito;
	protected Boleto boleto;
	protected Map<Produto, Integer> carrinho;
	protected iniciaPagamento pagamentos;
	
	protected double total = 0;
	
    public Loja(){      
    	this.cadastroComprador = new HashSet<>();  
      	this.cadastroVendedor = new HashSet<>();
      	this.carrinho = new HashMap<>();
      	this.pix = new Pix(this);
  		this.credito = new Credito(this);
  		this.debito = new Debito(this);
  		this.boleto = new Boleto(this);
  		this.pagamentos = new iniciaPagamento(this);
    }   

    
    public void registraComprador(Comprador comprador, double saldoInicial){    	   	
    	this.dadosComprador = comprador;
    	comprador.setSaldo(saldoInicial);
    	this.cadastroComprador.add(dadosComprador);
    }
    
    public void registraVendedor(Vendedor vendedor){      	
    	this.dadosVendedor = vendedor;    	
        this.cadastroVendedor.add(dadosVendedor);
    }
    
    public void operacao(String cpf, String cnpj) {  	
    	Operacao operation = new Operacao(cpf, cnpj, this.pagamentos, this.pix, this.debito, this.credito, this.boleto, this.carrinho);
    	operation.iniciaOperacao();
    	this.getComprador(cpf).comprasRealizadas += 1;
		this.getVendedor(cnpj).vendasRealizadas += 1;
    }
    
    public Comprador getComprador(String cpf){
    	Iterator<Comprador> compradorIterator = cadastroComprador.iterator();
        while (compradorIterator.hasNext()){
        	Comprador it = compradorIterator.next();
        	if(it.getCpf().equals(cpf)) {
        		System.out.println("\n"+it);
        		return it;
        	}
        }
        return null;
    }
    
    public Vendedor getVendedor(String cnpj){    	
    	Iterator<Vendedor> VendedorIterator = cadastroVendedor.iterator();
        while (VendedorIterator.hasNext()){
        	Vendedor it = VendedorIterator.next();
        	if(it.getCnpj().equals(cnpj)) {
        		System.out.println("\n"+it);
        		return it;
        	}
        }
        return null;
    }
    
    public void adicionaProduto(String cnpj){
    	Scanner escolhaProduto = new Scanner(System.in);
    	System.out.println("\nCadastro de produto.");
    	System.out.println("\nCodigo: ");
    	String codigo = escolhaProduto.nextLine();
    	System.out.println("\nNome: ");
    	String nome = escolhaProduto.nextLine();
    	System.out.println("\nPre�o: ");
    	double preco = escolhaProduto.nextDouble();
    	
    	Produto produto = new Produto(codigo, nome, preco);
    	
    	Iterator<Vendedor> VendedorIterator = cadastroVendedor.iterator();
        while (VendedorIterator.hasNext()){
        	Vendedor it = VendedorIterator.next();
        	if(it.getCnpj().equals(cnpj)) {
        		it.addProduto(produto);
        	}
        }
    }
    
    public double getTotal() {
    	return this.total;
    }

    public Pix getPix() {
    	return this.pix;
    }
    
    public String toString(){
	    String retorno = "";
	
	    for(Comprador comp: this.cadastroComprador){
	    	retorno += comp + "\n\n";
	    }
	      
	    for(Vendedor vend: this.cadastroVendedor){
	    	retorno += vend + "\n\n";
	    }
	    return retorno;
    }
}
