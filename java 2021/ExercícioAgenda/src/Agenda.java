
public class Agenda {

	//pode armazenar 10 pessoas
	
	private Pessoa[] array = new Pessoa[9];
	private int n = 0;
	
	/*public Agenda(Integer dia, Integer mes, Integer ano, String nome, Double altura) {
		super(dia, mes, ano, nome, altura);
	}*/
	
	public Agenda() {
	}

	public void armazenaPessoa(String nome, Data dtNascimento, float altura) {
		//Pessoa p = new Pessoa(dtNascimento, nome, altura);
		//dtNascimento = new Pessoa(12,7,2021);
		((Pessoa)dtNascimento).setNome(nome);
		((Pessoa)dtNascimento).setAltura(altura);
		array[n++] = (Pessoa) dtNascimento;
	}
	
	public void removePessoa(String nome) {
		for (int i = 0 ; i<n-1 ; i++) {
			if(nome == array[i].getNome()) {
				array[i] = null;
			}
		}
	}
	
	/*public void removePessoa(String nome) {
		int j =0;
		for (int i = buscaPessoa(nome) ; i<n-1 ; i++) {
			array[i] = array[i++];
			j = i++;
		}
		array[j++] = null;
	}*/
	
	public int buscaPessoa(String nome) { //informa em que posição da agenda está essa pessoa
		for (int i = 0 ; i<n ; i++) {
			if(array[i] != null) {
				if(nome == array[i].getNome()) {
					return i+1;
				} 
			}
		}
		return -1;
	}
	
	public void imprimeAgenda() { //imprime os dados de todas as pessoas da agenda
		for(int i=0 ; i<n ; i++) {
			System.out.println(array[i]);
		}
	}
	
	public void imprimePessoa(int index) { //imprime os dados da pessoa que está na posição "i" da agenda
		for (int i = 0 ; i<n ; i++) {
			if(index == i+1) {
				System.out.println(array[i]);
			} 
		}
	}
	
	public static void main(String[] args) {
		
		Agenda agenda = new Agenda(); 
		
		//Data dt = new Data(30, 03, 2000);
		
		//System.out.println(dt);
		
		/*dt = new Pessoa(15, 5, 2020);
		((Pessoa)dt).setNome("Ana");
		((Pessoa)dt).setAltura(1.63);*/
		
		//testes:
		
		Data dt = new Data(30, 3, 2000);
		dt = new Pessoa(30, 3, 2000);
		agenda.armazenaPessoa("Ana", dt, (float) 1.63);
		agenda.imprimeAgenda();
		System.out.println(agenda.buscaPessoa("Ana"));
		
		Data dt2 = new Data(7, 2, 2020);
		dt2 = new Pessoa(7, 2, 2020);
		agenda.armazenaPessoa("Paula", dt2, (float) 1.64);
		agenda.imprimeAgenda();
		agenda.imprimePessoa(2);
		System.out.println(agenda.buscaPessoa("Ana"));
		System.out.println(agenda.buscaPessoa("Paula"));
		
		agenda.removePessoa("Ana");
		agenda.imprimeAgenda();
		agenda.imprimePessoa(1);
		System.out.println(agenda.buscaPessoa("Paula"));
		
	}
}
