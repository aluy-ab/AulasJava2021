package model;

import java.util.List;

import singleton.SingletonFactory;
import util.Parameter;
import util.Parameter.Operator;

public class ModelPessoa extends Model {
	
	protected Integer idpessoa;
	protected String nome;
	
	public ModelPessoa () {
		super ( "pessoa", "nome ASC" );
		this.idpessoa = null;
	}

	public Integer getIdpessoa() {
		return idpessoa;
	}

	public void setIdpessoa(Integer idpessoa) {
		this.idpessoa = idpessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return idpessoa + "-" +nome;
	}
	
	public static void main(String[] args) {
		ModelPessoa p = new ModelPessoa();
		p.setIdpessoa( 10 );
		p.setNome("Teresinha");
		System.out.println(p);
		
		try {
			p.set( "nome", "Luis");
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
					getSqlSelect(p2, new Parameter("nome","Teresinha")) );
			
			System.out.println(SingletonFactory.getInstance().
					getSqlSelect(p2, new Parameter("idpessoa",10, Operator.EQUAL)) );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
