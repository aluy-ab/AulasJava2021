package model;

public class Produto {
	
	private Integer codigo;
	private String nome;
	private Integer qntd;
	private Double preco;
	
	public Produto() { //construtor sem parametros
		this.codigo = null;
	}
	
	public Produto(int codigo) { //construtor com o codigo
		this.codigo = codigo;
	}
	
	public Produto(Produto other) {//construtor com todos os atributos
		this.codigo = other.codigo;
		this.nome = other.nome;
		this.preco = other.preco;
		this.qntd = other.qntd;
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
	
	private double totaliza(Produto other) {
		double total;
		Produto aux = (Produto)other;
		total = aux.qntd * aux.preco;
		return total;
	}
	
	@Override
	public String toString() {
		return 	" Código: " + this.codigo +
				" Nome: " + this.nome +
				" Preço: " + this.preco +
				" Quantidade: " + this.qntd;
	}
	
	/*public static void main(String[] args) {
		UsaProduto produto = new UsaProduto();
		produto.
	}*/

}
