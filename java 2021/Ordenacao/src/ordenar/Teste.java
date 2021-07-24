package ordenar;

import java.util.Arrays;

import model.ComparableOld;
import model.ModelPessoa;

public class Teste {
	
	public static void main(String[] args) {
		/*
		BubbleSort bs = new BubbleSort();
			
		ModelPessoa pessoa =  new ModelPessoa();
		pessoa.setNome("Tokoyami");
		pessoa.setAltura(1.58);
		try {
			bs.add(pessoa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pessoa =  new ModelPessoa();
		pessoa.setNome("Kirishima");
		pessoa.setAltura(1.70);
		try {
			bs.add(pessoa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pessoa =  new ModelPessoa();
		pessoa.setNome("Jirou");
		pessoa.setAltura(1.54);
		try {
			bs.add(pessoa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pessoa =  new ModelPessoa();
		pessoa.setNome("Aoyama");
		pessoa.setAltura(1.68);
		try {
			bs.add(pessoa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bs.sort();
		bs.show(); */
		
		ModelPessoa[] pessoas = new ModelPessoa[100];
		int n=0;
		
		ModelPessoa pessoa =  new ModelPessoa();
		pessoa.setNome("Tokoyami");
		pessoa.setAltura(1.58);
		pessoas[n++] = pessoa;
		
		pessoa =  new ModelPessoa();
		pessoa.setNome("Kirishima");
		pessoa.setAltura(1.70);
		pessoas[n++] = pessoa;
		
		pessoa =  new ModelPessoa();
		pessoa.setNome("Jirou");
		pessoa.setAltura(1.54);
		pessoas[n++] = pessoa;
		
		pessoa =  new ModelPessoa();
		pessoa.setNome("Aoyama");
		pessoa.setAltura(1.68);
		pessoas[n++] = pessoa;
		
		Collections.sort2(pessoas, n);
		for (int i=0; i<n; i++) {
			System.out.println(pessoas[i]);
		}
		
		Integer aux = Collections.binarySearch(pessoas, 0, n-1, pessoa);
		
		System.out.println(aux);
		
		//System.out.println(pessoa);
		String[] nomes = new String[] {"rafael cosentino", "jonas hirata", "marcelo martins"};
		Arrays.sort(nomes);
		
		for(String nome : nomes) {
			System.out.println(nome);
		}
		
	}

}
