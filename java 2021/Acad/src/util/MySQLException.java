package util;

import java.sql.SQLException;

public class MySQLException extends SQLException {

	private static final long serialVersionUID = -2626971574221603629L;
	
	private Integer cod;
	
	public MySQLException (Integer cod, SQLException e) {
		super(e);
		this.cod = cod;
	}
	
	public Integer getCod() {
		return this.cod;
	}

}
