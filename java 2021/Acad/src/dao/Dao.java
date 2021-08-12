package dao;

import model.Model;
import singleton.SingletonDB;
import singleton.SingletonFactory;
import util.Parameter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	
	private Model model;
	private ResultSet resultado;
	private SingletonFactory factory = SingletonFactory.getInstance();
	
	public Dao(Model model) {
		this.model = model;
	}
	
	protected ArrayList<Model> getResultado() throws Exception{
		ArrayList<Model> list = new ArrayList<Model>();
		Model m;
		while(this.resultado.next()) {
			List<String> sl = this.model.getClassAttribute();
			m = this.model.getNewModel();
			for (String fieldName : sl) {
				m.set(fieldName, resultado.getObject(fieldName));
			}
			list.add(m);
		}
		return list;
	}
	
	protected void execute(String sql) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		System.out.println(sql);
		SingletonDB.getInstance().getStatement().execute(sql);
		this.resultado = SingletonDB.getInstance().getStatement().getResultSet();
	}
	
	//update e insert
	public void salvar(Model model) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException,
											NoSuchFieldException, SecurityException, IllegalArgumentException, Exception {
		String sql = "";
		if(model.getId()==null) {
			sql = factory.getSqlInsert(model);
		} else {
			sql = factory.getSqlUpdate(model);
		}
		execute(sql);
	}
	
	//delete
	public void excluir(Model model) throws Exception {
		String sql = factory.getSqlDelete(model);
		execute(sql);
	}
	
	//select
	public ArrayList<Model> consultar(Parameter... params) throws Exception {
		String sql = factory.getSqlSelect(model, params);
		execute(sql);
		return getResultado();
	}
	
	public static void main(String[] args) {
		//Dao dao = new Dao(new ModelPessoa());
	}

}
