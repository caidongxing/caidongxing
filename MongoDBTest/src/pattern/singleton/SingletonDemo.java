package pattern.singleton;

public class SingletonDemo {

	public static void main(String[] args) {
		SingletonObject instance = SingletonObject.getInstance();
		SingletonObject instance2 = SingletonObject.getInstance();
		
		instance.message();
	}

}
