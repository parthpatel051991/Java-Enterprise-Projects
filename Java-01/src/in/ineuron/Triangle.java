package in.ineuron;

public class Triangle implements Shape {


	private Double side1;
	private Double side2;
	private Double side3;
	
	
	public Triangle(Double side1, Double side2, Double side3) {
		super();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	@Override
	public Double calculateArea() {
		//Using Heron's formula to calculate the area of a trianglr
		double s = (side1+side2+side3);
		return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
	}

	@Override
	public Double calculatePerimeter() {
		
		return side1+side2+side3;
	}

}
