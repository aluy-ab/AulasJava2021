package singleton;

import java.util.List;

import model.Model;
import util.Parameter;

public class SingletonFactory {
	
	private static SingletonFactory me = new SingletonFactory();
	
	private SingletonFactory() {
	}
	
	public static SingletonFactory getInstance () {
		return me;
	}
	
	private String getFieldList ( Model model ) {
		String s="";
		String separador="";
		List<String> sl = model.getClassAttribute();
		for (String field : sl) {
			s += separador + field;
			separador = ",";
		}
		return s;
	}
	
	private String getValueList ( Model model ) throws Exception {
		String s="";
		String separador="";
		List<String> sl = model.getClassAttribute();
		for (String field : sl) {
			if (model.get(field)==null) {
				s += separador + model.get(field);
			} else {
				s += separador + "'" + model.get(field) + "'";
			}
			separador = ",";
		}
		return s;
	}
	
	private String getFieldValue ( Model model ) throws Exception {
		String s="";
		String separador="";
		List<String> sl = model.getClassAttribute();
		for (String field : sl) {
			s += separador + field + "='" + model.get(field) + "'";
			separador = ",";
		}
		return s;
	}
	
	private String getWhere ( Model model, Parameter... params ) {
		String s="";
		String separador=" WHERE ";
		for (Parameter parameter : params) {
			switch (parameter.getOperator()) {
			case EQUAL:
				s += separador + 
					 parameter.getName() + "='" +
					 parameter.getValue() +"'";
				break;
			case LIKE:
				s += separador +
				     parameter.getName() + " LIKE '%" +
				     parameter.getValue() +"%' ";
				break;
			default:
				break;
			}
			separador = " AND ";
		}
		return s;		
	}
	
	private String getOrderBy ( Model model ) {
		String s = model.getOrderBy();
		return (s==""? "" : " ORDER BY " + s); 
	}
		
	public String getSqlInsert ( Model model ) throws Exception {
		//INSERT INTO table_name (column1, column2, column3, ...)
		//VALUES (value1, value2, value3, ...);
		return "INSERT INTO " + model.getTableName() + 
				 " (" + getFieldList (model) + ") " +
				 " VALUES (" + getValueList (model) + ")";
	}
	
	public String getSqlUpdate ( Model model ) throws Exception {
		//UPDATE table_name
		//SET column1 = value1, column2 = value2, ...
		//WHERE condition;
		return "UPDATE " + model.getTableName() + 
				 " SET " + getFieldValue (model) + 
				 " WHERE " + model.getIdName() + "=" + 
				             model.get(model.getIdName());
	}
	
	public String getSqlDelete ( Model model ) throws Exception {
		//DELETE FROM table_name WHERE condition;
		return "DELETE FROM " + model.getTableName() + 
			   " WHERE " + model.getIdName() + "=" + 
				           model.get(model.getIdName());
	}
	
	public String getSqlSelect ( Model model, Parameter... params ) throws Exception {
		//SELECT * FROM table_name WHERE condition ORDER BY field;
		return "SELECT * FROM " + model.getTableName() +
				getWhere (model, params) +
				getOrderBy(model);
	}
	
}
