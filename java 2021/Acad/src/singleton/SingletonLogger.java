package singleton;

public class SingletonLogger {
	
	private static SingletonLogger me = new SingletonLogger();
	
	private SingletonLogger() {
	}
	
	public static SingletonLogger getInstance() {
		return me;
	}
	
	public void doLog(String...strings) {
		for(String string : strings) {
			System.out.println(string); 
		}
	}
	
}
