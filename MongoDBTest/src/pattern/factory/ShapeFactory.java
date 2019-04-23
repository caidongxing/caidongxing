package pattern.factory;

public class ShapeFactory {
	
	public Shape getShape(String type) {
		if(type==null) {
			return null;
		}
		if(type.equalsIgnoreCase("rectengle")) {
			return new Rectengle();
		}else if(type.equalsIgnoreCase("circle")) {
			return new Circle();
		}else if(type.equalsIgnoreCase("square")) {
			return new Square();
		}
		return null;
	}
}
