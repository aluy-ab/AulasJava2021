package model;

public class ModelPessoa implements Comparable {
	
	private Integer idpessoa;
	private String nome;
	private Double altura;
	
	public ModelPessoa() { //construtor
		this.idpessoa = null;
	}

	public Integer getIdpessoa() {
		return idpessoa;
	}

	public void setIdpessoa(Integer idpessoa) {
		this.idpessoa = idpessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}
	
	
	@Override
	public int compareTo(Comparable other) {
		ModelPessoa p = (ModelPessoa)other; //casting
		
		if(this.altura<p.getAltura()) return -1;
		if(this.altura==p.getAltura()) return 0;
		return 1;
		
		//return this.nome.compareToIgnoreCase(p.getNome());
	}
	
	@Override
	public Boolean equals(Comparable other) {
		ModelPessoa p = (ModelPessoa)other; //casting
		return this.idpessoa == p.idpessoa;
	}
	
	@Override
	public String toString() {
		return 	" Id: " + this.idpessoa +
				" Nome: " + this.nome +
				" Altura: " + this.altura;
	}
	
	public static void main(String[] args) {
		
		ModelPessoa pessoa = new ModelPessoa();
		pessoa.setNome("Ana");
		pessoa.setAltura(1.63);
		
		System.out.println(pessoa);
	}
	
}
