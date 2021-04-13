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
	protected FormaPagamento formaPagamento;
	protected Map<Produto, Integer> carrinho;
	
	protected double total = 0;
	
    public Loja(){      
      this.cadastroComprador = new HashSet<>();  
      this.cadastroVendedor = new HashSet<>();
      this.carrinho = new HashMap<>();
      this.formaPagamento = new FormaPagamento(this);
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
    	Operacao operation = new Operacao(cpf, cnpj, this.formaPagamento, this.carrinho);
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
    	System.out.println("\nPreço: ");
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
