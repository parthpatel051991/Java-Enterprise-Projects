package in.ineuron.abstractclasses;

public class AbstractClassExample {

	public static void main(String[] args) {
        Circle circle = new Circle("Circle", 5.0);
        circle.display();
        System.out.println("Area: " + circle.calculateArea());
    }
}
