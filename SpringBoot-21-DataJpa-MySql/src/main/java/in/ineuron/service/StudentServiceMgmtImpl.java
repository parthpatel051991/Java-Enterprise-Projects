package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Student;
import in.ineuron.repo.IStudentRepository;

@Service("service")
public class StudentServiceMgmtImpl implements IStudentServiceMgmt {

	@Autowired
	private IStudentRepository repo;
	
	
	@Override
	public String registerStudent(Student student) {
	
		Student registredStudent=null;
		
		if (student!=null) {
			registredStudent = repo.save(student);			
		}
		
		
		return (registredStudent!=null)? "Student registred succesfully with id number:: "+registredStudent.getSid():"Student registration is failed";
	}

}
