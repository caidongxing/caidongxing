package pattern.singleton;

public class SingletonObject {
	
	private SingletonObject() {}
	
	private static SingletonObject instance=new SingletonObject();
	
	public static SingletonObject getInstance() {
		return instance;
	}
	public String message() {
		return "Hello Word";
	}
}
