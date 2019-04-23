package pattern.Abstract.factory;

import pattern.factory.Shape;

public class AbstractFactoryDemo {

	public static void main(String[] args) {

		AbstractFactory abstractFactory = FactoryProducer.getFactory("shape");
		Shape shape = abstractFactory.getShape("square");
		shape.draw();
		AbstractFactory abstractFactory2 = FactoryProducer.getFactory("color");
		
		Color color = abstractFactory2.getColor("green");
		color.fill();
	}

}
