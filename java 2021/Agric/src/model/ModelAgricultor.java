package model;

import java.util.List;

import singleton.SingletonFactory;
import util.Parameter;
import util.Parameter.Operator;

public class ModelAgricultor extends Model {
	
	protected Integer idagricultor;
	protected String nome;
	
	public ModelAgricultor () {
		super ( "agricultor", "nome ASC" );
		this.idagricultor = null;
	}

	public Integer getIdagricultor() {
		return idagricultor;
	}

	public void setIdagricultor(Integer idagricultor) {
		this.idagricultor = idagricultor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return idagricultor + "-" +nome;
	}
	
	public static void main(String[] args) {
		ModelAgricultor p = new ModelAgricultor();
		p.setIdagricultor( 10 );
		p.setNome("Maria Cana");
		System.out.println(p);
		
		try {
			p.set( "nome", "João Soja");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<String> list = p.getClassAttribute();
		for (String string : list) {
			try {
				System.out.println(string + ": " + p.get(string));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Model p2 = p.clone();
		System.out.println(p2);
		
		try {
			
			System.out.println(SingletonFactory.getInstance().getSqlInsert(p2));
			System.out.println(SingletonFactory.getInstance().getSqlUpdate(p2));
			System.out.println(SingletonFactory.getInstance().getSqlDelete(p2));
			System.out.println(SingletonFactory.getInstance().getSqlSelect(p2));
			
			System.out.println(SingletonFactory.getInstance().
					getSqlSelect(p2, new Parameter("nome","Maria Cana")) );
			
			System.out.println(SingletonFactory.getInstance().
					getSqlSelect(p2, new Parameter("idagricultor",10, Operator.EQUAL)) );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
