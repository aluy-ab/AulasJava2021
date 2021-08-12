package teste;

import dao.Dao;
import model.Model;
import model.ModelPessoa;
import util.Parameter.Operator;
import java.util.ArrayList;

public class Teste {
	
	public static void main(String[] args) throws Exception{
		
		Dao dao = new Dao(new ModelPessoa());
		
		ModelPessoa p = new ModelPessoa();
		p.setIdpessoa(2);
		//p.setNome("Aithusa");
		
		//dao.salvar(p);
		//dao.excluir(p);
		ArrayList<Model> al = dao.consultar(new util.Parameter("nome", "Ana Paula",	Operator.EQUAL));
	
		for (Model model : al) {
			System.out.println(model);
		}
	}

}
