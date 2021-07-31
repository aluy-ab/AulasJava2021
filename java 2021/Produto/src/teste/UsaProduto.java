package teste;

import singleton.Logger;

public class UsaProduto extends Quimico {
	
	public static void main(String[] args) {
		Produto p = new Produto(1, "Abacaxi", 5, 5.30);
		
		System.out.println(p);
		
		try {
			p.atualizaPreco(-10);
		} catch (Exception e) {
			Logger.getInstance().doLog(e.getMessage(), "Teste1", "Teste2");
		}
		System.out.println(p);
		
		p = new Quimico(1, "Álcool", 10, 5.00);
		((Quimico)p).setInfl(true); //type casting
		
		System.out.println(p);
		
		try {
			p.atualizaPreco(10); 
		} catch (Exception e) {
			Logger.getInstance().doLog(e.getMessage(), "Teste2");
		}
		System.out.println(p); //polimorfismo
	}

}
