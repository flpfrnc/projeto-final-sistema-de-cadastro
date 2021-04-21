# projeto-final-sistema-de-cadastro
Sistema de cadastro de compradores e vendedores utilizando conceitos de Java estudados

- Utilizar uma classe abstrata FormaPagamento com um método abstrato para tratar o pagamento.
  ##### Classe FormaPagamento alterada para forma abstrata com o método abstrato: 
  ```java
  public abstract void pagamento(String cpf, String cnpj); 
  ```
  ##### Método encontrado na classe
  <ul>
    <li><a href="/src/bti/ufrn/imd/assets/FormaPagamento.java">FormaPagamento</a></li>
  </ul>
    
- Criar uma classe concreta para cada forma de pagamento que herde de FormaPagamento e implemente o método abstrato.
  ##### Classes concretas seguem a mesma implementação da classe abaixo, herdando de FormaPagamento, e sobrescrevendo o método pagamento():
  ```java 
  public class Pix extends FormaPagamento{

	public Pix(Loja loja, double total) {
		super(loja);
		this.getLoja().setTotal(total);
	}
	
	@Override
	public void pagamento(String cpf, String cnpj) {
		System.out.println("Total atual: " + super.getLoja().getTotal());
		this.getLoja().getComprador(cpf).decreSaldo(this.getLoja().getTotal());
		this.getLoja().getVendedor(cnpj).increSaldo(this.getLoja().getTotal());
	}
	
  }
  /* decreSaldo() / increSaldo() substituindo ações de incremento com operadores */
  ```
  ##### Classes mencionadas:
  <ul>
    <li><a href="/src/bti/ufrn/imd/assets/Pix.java">Pix</a></li>
    <li><a href="/src/bti/ufrn/imd/assets/Boleto.java">Boleto</a></li>
    <li><a href="/src/bti/ufrn/imd/assets/Debito.java">Debito</a></li>
    <li><a href="/src/bti/ufrn/imd/assets/Credito.java">Credito</a></li>
  </ul>
  
- Utilizar corretamente generics no uso das coleções da Java Collection.
  ##### Generics utilizado em variáveis como: 
  ```java
  private Set<Comprador> cadastroComprador;
  private Set<Vendedor> cadastroVendedor;
  protected Map<Produto, Integer> carrinho;
  ```
  ##### Contidas em 
  <ul>
    <li><a href="/src/bti/ufrn/imd/assets/Loja.java">Loja</a></li>
  </ul>
- Utilizar corretamente o pacote java.time
  ##### java.time foi utilizada para a criação de datas para comparação com a data do boleto:
  ```java
  import java.time.LocalDate;
  ...
  public void setDataBoleto(int dia, int mes, int ano) {
		this.dataBoleto = LocalDate.of(ano, mes, dia);
  }
  ```
  <ul>
    <li><a href="/src/bti/ufrn/imd/assets/Boleto.java">Boleto</a></li>
  </ul>
  
- Utilizar corretamente o tipo especial Enum
  ##### o tipo Enum foi utilizado para o acesso ao menu de funcionalidades:
  ```java
  public enum MenuEnum {
    IMPRIMIR_DADOS_CLIENTE(1, "Imprimir dados do Cliente;"),
    IMPRIMIR_DADOS_VENDEDOR(2, "Imprimir dadoos do Vendedor;"),
    REGISTRAR_PRODUTO(3, "Registrar Produto;"),
    COMPRAR_VENDER_PRODUTO(4, "Comprar/Vender;"),
    FECHAR_PROGRAMA(5, "Digite 5 ou 0 para sair...");

    private final int value;
    private final String message;

    private MenuEnum(int value, String message) {
      this.value = value;
      this.message = message;
    }

    public int getValue() {
      return value;
    }

    public String getMessage() {
      return message;
    }
  }
  ```
  ##### (Enum) Encontrado nas classes:
  <ul>
    <li><a href="/src/bti/ufrn/imd/assets/MenuEnum.java">MenuEnum</a></li>
    <li><a href="/src/bti/ufrn/imd/assets/OperacaoEnum.java">OperacaoEnum</a></li>
  </ul>
- Utilizar pelo menos uma annotation de marcação
  ##### A annotation mais utilizada foi o @override, que também pode ser encontrado nas classes:
  <ul>
    <li><a href="/src/bti/ufrn/imd/assets/Pix.java">Pix</a></li>
    <li><a href="/src/bti/ufrn/imd/assets/Boleto.java">Boleto</a></li>
    <li><a href="/src/bti/ufrn/imd/assets/Debito.java">Debito</a></li>
    <li><a href="/src/bti/ufrn/imd/assets/Credito.java">Credito</a></li>
    <li><a href="/src/bti/ufrn/imd/assets/Comprador.java">Comprador</a></li>
    <li><a href="/src/bti/ufrn/imd/assets/Vendedor.java">Vendedor</a></li>
  </ul>
