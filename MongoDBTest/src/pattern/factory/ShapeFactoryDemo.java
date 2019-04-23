package pattern.factory;

public class ShapeFactoryDemo {

	public static void main(String[] args) {
		ShapeFactory factory =new ShapeFactory();
		Shape shape1=factory.getShape("circle");
		shape1.draw();
		Shape shape2 = factory.getShape("rectengle");
		shape2.draw();
		Shape shape3 = factory.getShape("square");
		shape3.draw();
	}

}
