package in.ineuron.intefaceconcept;

public class Circle implements Shape {

	private String name;
	private double radius;

	public Circle(String name, double radius) {
		this.name = name;
		this.radius = radius;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double calculateArea() {
		return Math.PI * radius * radius;
	}

}
