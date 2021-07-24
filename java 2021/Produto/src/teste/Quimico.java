package teste;

public class Quimico extends Produto{
	
	private Boolean infl;
	
	public 	Quimico() { 	//construtor sem parametros
		this(null, "", 0 ,0.0);
		this.infl = false;
	}
	
	public Quimico(Integer codigo) { 	//construtor inicializando
		//this.codigo = codigo;
		//this.nome = "";
		//this.qntd = 0;
		//this.preco = 0.0;
		this(codigo, "", 0, 0.0);		
	}
	
	public Quimico(Integer codigo, String nome, Integer qntd, Double preco) { 	//construtor com passagem de todos os atributos
		super(codigo, nome, qntd, preco);
	}

	public Boolean getInfl() {
		return infl;
	}

	public void setInfl(Boolean infl) {
		this.infl = infl;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + (this.infl? "sim" : " ");
	}
	
	public static void main(String[] args) {
		Quimico q = new Quimico(1, "Álcool", 10, 5.00);
		q.setInfl(true);
		
		System.out.println(q);
		
		try {
			q.atualizaPreco(10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(q);
	}

}
