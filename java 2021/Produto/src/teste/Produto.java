package teste;

public class Produto {
	
	private Integer codigo;
	private String nome;
	private Integer qntd;
	private Double preco;
	
	public Produto() { //construtor sem parametros
		this(null, "", 0 ,0.0);
	}
	
	public Produto(Integer codigo) { //construtor inicializando
		//this.codigo = codigo;
		//this.nome = "";
		//this.qntd = 0;
		//this.preco = 0.0;
		this(codigo, "", 0, 0.0);		
	}
	
	public Produto(Integer codigo, String nome, Integer qntd, Double preco) {//construtor com passagem de todos os atributos
		this.codigo = codigo;
		this.nome = nome;
		this.qntd = qntd;
		this.preco = preco;
	}

	//Getters e Setters:
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQntd() {
		return qntd;
	}

	public void setQntd(Integer qntd) {
		this.qntd = qntd;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public void atualiza_preco(int porcent) {
		this.preco += porcent * this.preco;
	}
	
	protected void atualizaPreco(Integer percentual) throws Exception {
		if(percentual < 0) {
			throw new Exception("Percentual inválido!");
		}
		this.preco += (this.preco*(double)percentual)/100.00;
	}
	
	private Double totaliza() {
		return this.qntd * this.preco;
	}
	
	@Override
	public String toString() {
		/*return 	" Código: " + this.codigo +
				" Nome: " + this.nome +
				" Preço: " + this.preco +
				" Quantidade: " + this.qntd;*/
		return this.codigo + " " + nome + " " + qntd + " " + preco + " " + this.totaliza();
	}
	
	public static void main(String[] args) {
		Produto p = new Produto(1, "Abacaxi", 5, 5.30);
		
		System.out.println(p);
		
		try {
			p.atualizaPreco(10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(p);
	}

}
