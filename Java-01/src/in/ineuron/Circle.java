package in.ineuron;

public class Circle implements Shape {

	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public Double calculateArea() {
		
		return Math.PI * radius*radius;
	}

	@Override
	public Double calculatePerimeter() {
		
		return 2*Math.PI*radius;
	}
	
	
	

}
