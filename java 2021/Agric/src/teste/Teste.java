package teste;

import java.util.ArrayList;

import dao.Dao;
import model.Model;
import model.ModelAgricultor;

public class Teste {
	
	public static void main(String[] args) throws Exception {
		
		Dao dao = new Dao ( new ModelAgricultor() );
		
		
		ModelAgricultor p = new ModelAgricultor();
		p.setIdagricultor( 2 );
		//p.setNome("Marcos Guaraná");
		
		//dao.salvar(p);
		//dao.excluir(p);
		ArrayList<Model> al = dao.consultar( );
		
				//new util.Parameter("nome", "Maria Cana") );
		
		for (Model model : al) {
			System.out.println(model);
		}
		
		
		
	}

}
