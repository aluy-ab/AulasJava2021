package model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Model {
	
	private String tableName;
	private String orderBy;
	
	public Model ( String tableName, String orderBy ) {
		this.tableName = tableName;
		this.orderBy = orderBy;
	}
	
	public String getTableName () {
		return this.tableName;
	}
	
	public String getOrderBy () {
		return this.orderBy;
	}
	
	public String getIdName () {
		return "id" + tableName;
	}

	public Object getId () throws Exception {
		return get ( getIdName() );
	}
	
	public List<String> getClassAttribute() {
		Field[] fields = this.getClass().getDeclaredFields();
		List<String> sl = new  ArrayList<String>();
		for (Field field : fields) {
			sl.add(field.getName());
		}		
		return sl;
	}

	public Object get ( String attr_name ) throws Exception {
		Field field = this.getClass().getDeclaredField(attr_name);
		return field.get(this);    	
	}

	public void set ( String attr_name, Object value  )  throws Exception {
		Field field =  this.getClass().getDeclaredField(attr_name);
		field.set(this, value);
	}
	
	public Model getNewModel () throws Exception {
		return this.getClass().newInstance();
	}

	@Override
	public Model clone ()  {
		Model model = null;
		try {
			model = this.getClass().newInstance();

			List<String> list = getClassAttribute();
			for (String attr : list) {
				model.set(attr, this.get(attr));
			} 
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		return model;
	}
	
}
