package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import util.MySQLException;

public class SingletonDB {
	
	protected Connection db = null;
	protected Statement stmt = null;
	
	private static SingletonDB me = null;
	
	private SingletonDB () {
	}
	
	public static SingletonDB getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		if (me==null) {
			me = new SingletonDB();			
			me.connect( "localhost", "acad", 3306, "root", "" );
			me.createStatement();
			System.out.println(me);
		}				
		return me;
	}	
	
	protected void createStatement() throws MySQLException {
			try {
				if (this.stmt != null)
					this.stmt.close();
				
				stmt = db.createStatement();
			} catch (SQLException e) {
				throw new MySQLException(2, e);
			}
	}
	
	public Statement getStatement() {
		return stmt;
	}
	
	protected void connect ( String server, 
			String database, int port, 
			String user, String password ) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException  {

		String db_connect_string = "jdbc:mysql://" + 
				server + ":" + port + "/" + database +
				"?verifyServerCertificate=false"+
				"&useSSL=false"+
				"&requireSSL=false"+
				"&useTimezone=true"+
				"&serverTimezone=UTC";

		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		if (this.db != null)
			this.db.close();
		db = DriverManager.getConnection(db_connect_string, 
				user, password);
	}
	
	public String toString () {
		try {
			return "Status connection Banco database: " +
					(me.db.isClosed()? "closed" : "open");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(SingletonDB.getInstance());
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

}