package in.ineuron.abstractclasses;

public abstract class Shape {

	private String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract double calculateArea();

    public void display() {
        System.out.println("Name: " + name);
    }
	
}
