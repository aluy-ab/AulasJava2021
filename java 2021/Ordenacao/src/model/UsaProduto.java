package model;

public class UsaProduto extends Quimico {
	
	public static void main(String[] args) {
		
		Quimico quim = new Quimico();
		quim.setCodigo(23);
		quim.setNome("Espada de Madeira");
		quim.setPreco(20.00);
		quim.setQntd(2);
		quim.setInfl(false);
		
		System.out.println(quim);
		
	}

}
