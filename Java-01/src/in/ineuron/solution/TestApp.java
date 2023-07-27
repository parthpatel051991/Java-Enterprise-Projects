package in.ineuron.solution;

import in.ineuron.Circle;
import in.ineuron.Triangle;

public class TestApp {

	public static void main(String[] args) {
	
		Circle circle = new Circle(5.00);
		System.out.println("Circle's Area is ::"+circle.calculateArea());
		System.out.println("Circle's perimeter is ::"+circle.calculatePerimeter());
		
		Triangle triangle = new Triangle(5.00, 10.00, 7.00);

		System.out.println("Triangle's Area is ::"+triangle.calculateArea());
		System.out.println("Traingle's Perimeter is ::"+triangle.calculatePerimeter());
	}

}
