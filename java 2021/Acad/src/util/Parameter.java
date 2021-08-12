package util;

public class Parameter {
	
	public enum Operator {EQUAL, LIKE}
	
	private String name;
	private Object value;
	private Operator operator;
	
	public Parameter(String name, Object value) {
		this.name = name;
		this.value = value;
		this.operator = Operator.LIKE;
	}
	
	public Parameter(String name, Object value, Operator operator) {
		this.name = name;
		this.value = value;
		this.operator = operator;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

	public Operator getOperator() {
		return operator;
	}
	
	

}
