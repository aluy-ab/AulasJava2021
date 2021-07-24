package logica;

class Conta {
	private double saldo = 0;
	private double limite = 600;
	private int numero;
	
	public Conta(int numero) {
		this.numero = numero;
	}
	
	Conta(int numero, double limite){
		this(numero);
		this.limite = limite;
	}
	
	public void deposita(int saldo) throws Exception {
		if(saldo>0) {
			this.saldo += saldo;
		} else {
			throw new Exception("Impossível depositar valores negativos");
		}
	}
	
	public void saca(double valor) {
		this.saldo -= valor;
	}
	
	public void imprimeExtrato() {
		System.out.println("SALDO: " + this.saldo);
	}
}

public class OlaMundo {
	
	public void teste(Conta conta) {
		try {
			conta.deposita(100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void teste2(int i) {
		i++;
	}
	
	public static void main(String[] args) {
		
		Conta conta = new Conta(1);
		//ref.saldo = 1000;
		//ref.limite = 500;
		//ref.numero = 1;
		
		try {
			new OlaMundo().teste(conta);
			conta.deposita(-1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		Integer i=0;
		new OlaMundo().teste2(i);
		System.out.println(i);
		
		conta.imprimeExtrato();
		conta.saca(100);
		conta.imprimeExtrato();
		/*
		String x = "João Maria;José";
		System.out.println(x);
		String[] teste = x.split(" |;");
		for(String string : teste) {
			System.out.println(string);
		}
		
		//sysout + ctrl+space
		System.out.println("Olá Mundo");
		//Integer x = Integer.MAX_VALUE
			
		int[] v= {10,12,100,12,40,30,2,8,-1,-100};
		Integer maior = null;
		
		for(int i=0; i<v.length; i++) {
			if((i==0)||(maior<v[i])) {
				maior = v[i];
			}
		}
		
		System.out.println(maior);
		
		int cinco = 10/3;
		System.out.println(cinco);
		
		//double teste = 10.0/3.0;
		//System.out.println(teste);
		
		System.err.println(5);
		*/
	}
	
}
