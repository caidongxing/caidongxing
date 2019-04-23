package pattern.Abstract.factory;

import pattern.factory.Shape;

public abstract class AbstractFactory {

	public abstract Shape getShape(String shape);
	
	public abstract Color getColor(String color);
}
