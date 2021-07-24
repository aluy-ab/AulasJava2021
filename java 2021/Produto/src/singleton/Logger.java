package singleton;

public class Logger {
	
	private static Logger me = new Logger();
	
	private Logger() {
	}
	
	public static Logger getInstance() {
		return me;
	}
	
	public void doLog(String...strings) {
		for(String string : strings) {
			System.out.println(string); 
		}
	}
	
}
