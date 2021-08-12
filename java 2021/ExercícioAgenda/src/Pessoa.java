
public class Pessoa extends Data{
	
	private String nome;
	private float altura;
	
	/*public Pessoa(Integer dia, Integer mes, Integer ano, String nome, Double altura) {
		super(dia, mes, ano);
		this.nome = nome;
		this.altura = altura;
	}*/
	
	public Pessoa(Integer dia, Integer mes, Integer ano) {
		super(dia, mes, ano);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	public Integer getIdade(Integer diaAtual, Integer mesAtual, Integer anoAtual) {
		if((this.getMes()<mesAtual) || ((this.getMes()==mesAtual) && (this.getDia()<=diaAtual))){
			return this.distAno();
		} else {
			return this.distAno() - 1;
		}
	}
	
	@Override
	public String toString() {
		return "Nome: " + getNome() +
				", Data de nascimento: " + super.toString() +
				", Altura: " + getAltura();
	}
	
	public static void main(String[] args) {
		Pessoa p = new Pessoa(26, 01, 2002);
		p.setNome("Ana");
		p.setAltura((float) 1.63);
		System.out.println(p);
		System.out.println(p.getIdade(5, 8, 2021));
	}

}
