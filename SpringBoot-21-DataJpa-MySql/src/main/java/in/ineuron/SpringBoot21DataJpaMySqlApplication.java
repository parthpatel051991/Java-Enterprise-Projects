package in.ineuron;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.ineuron.model.Student;
import in.ineuron.service.StudentServiceMgmtImpl;

@SpringBootApplication
public class SpringBoot21DataJpaMySqlApplication {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBoot21DataJpaMySqlApplication.class, args);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the details for new Student");
		
		System.out.print("Enter the name::");
		String name = sc.next();
		System.out.print("Enter the address::");
		String address = sc.next();
		
		System.out.print("Enter the age::");
		int age = sc.nextInt();
		
	    StudentServiceMgmtImpl service = context.getBean(StudentServiceMgmtImpl.class);
	    
	    Student student = new Student(null, name, age, address);
	    
	    String result = service.registerStudent(student);
	    
	    System.out.println(result);
	}

}
