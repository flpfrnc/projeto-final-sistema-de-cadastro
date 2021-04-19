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
	protected IniciaPagamento pagamentos;
	protected double total = 0;
	
    public Loja(){      
    	this.cadastroComprador = new HashSet<>();  
      	this.cadastroVendedor = new HashSet<>();
      	this.carrinho = new HashMap<>();
      	this.pix = new Pix(this, this.total);
  		this.credito = new Credito(this, this.total);
  		this.debito = new Debito(this, this.total);
  		this.boleto = new Boleto(this, this.total);
  		this.pagamentos = new IniciaPagamento(this);
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
    	Operacao operation = new Operacao(cpf, cnpj, this.pagamentos, this.carrinho, this.total);
    	operation.iniciaOperacao();
    	//this.getComprador(cpf).comprasRealizadas += 1;
		//this.getVendedor(cnpj).vendasRealizadas += 1;
    }
    
    public Comprador getComprador(String cpf){
    	Iterator<Comprador> ListaComprador = cadastroComprador.iterator();
        while (ListaComprador.hasNext()){
        	Comprador compradorAtual = ListaComprador.next();
        	if(compradorAtual.getCpf().equals(cpf)) {
        		return compradorAtual;
        	}
        }
        return null;
    }
    
    public void printComprador(String cpf) {
    	System.out.println(getComprador(cpf));
    }
    
    public Vendedor getVendedor(String cnpj){    	
    	Iterator<Vendedor> ListaVendedor = cadastroVendedor.iterator();
        while (ListaVendedor.hasNext()){
        	Vendedor vendedorAtual = ListaVendedor.next();
        	if(vendedorAtual.getCnpj().equals(cnpj)) {
        		return vendedorAtual;
        	}
        }
        return null;
    }
    
    public void printVendedor(String cnpj) {
    	System.out.println(getVendedor(cnpj));
    }
    
    public void adicionaProduto(String cnpj){
    	Scanner dadosProduto = new Scanner(System.in);
    	
    	System.out.println("\nCadastro de produto.");
    	System.out.println("\nCodigo: ");
    	String codigo = dadosProduto.nextLine();
    	System.out.println("\nNome: ");
    	String nome = dadosProduto.nextLine();
    	System.out.println("\nPreço: ");
    	double preco = dadosProduto.nextDouble();
    	
    	Produto produto = new Produto(codigo, nome, preco);
    	
    	Iterator<Vendedor> VendedorIterator = cadastroVendedor.iterator();
        while (VendedorIterator.hasNext()){
        	Vendedor catalogoVendedor = VendedorIterator.next();
        	if(catalogoVendedor.getCnpj().equals(cnpj)) {
        		catalogoVendedor.addProduto(produto);
        	}
        }
    }
    
    public double getTotal() {
    	return this.total;
    }
    
    public void setTotal(double updatedTotal) {
    	this.total = updatedTotal;
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
