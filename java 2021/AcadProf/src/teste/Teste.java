package teste;

import java.util.ArrayList;

import dao.Dao;
import model.Model;
import model.ModelPessoa;

public class Teste {
	
	public static void main(String[] args) throws Exception {
		
		Dao dao = new Dao ( new ModelPessoa() );
		
		
		ModelPessoa p = new ModelPessoa();
		p.setIdpessoa( 2 );
		//p.setNome("Emanuelle da Costa Monteiro");
		
		//dao.salvar(p);
		//dao.excluir(p);
		ArrayList<Model> al = dao.consultar( );
		
				//new util.Parameter("nome", "Teresinha") );
		
		for (Model model : al) {
			System.out.println(model);
		}
		
		
		
	}

}
