package in.ineuron.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="empTab")
public class Employee {

	@Id
	@Column(name="eid")
	private Integer empId;
	
	@Column(name="ename",length = 20)
	private String empName;
	
	@Column(name="esal")
	private Double empSal;
	
	static {
		System.out.println("Employee.class is loading");
	}
	
	public Employee() {
		System.out.println("zero argument constructor.");
	}
	
	
}
