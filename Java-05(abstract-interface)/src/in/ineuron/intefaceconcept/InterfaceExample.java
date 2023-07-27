package in.ineuron.intefaceconcept;

public class InterfaceExample {

	public static void main(String[] args) {
        Circle circle = new Circle("Circle", 5.0);
        System.out.println("Name: " + circle.getName());
        System.out.println("Area: " + circle.calculateArea());
    }
}
