package in.ineuron.factory;

import in.ineuron.dao.StudentDao;
import in.ineuron.dao.StudentDaoImpl;

public class StudentDaoFactory {

	private StudentDaoFactory() {}

	private static StudentDao studentDao=null;
	
	public static StudentDao getStudentDao() {
		
		if (studentDao==null) {
			studentDao=new StudentDaoImpl();
		}
		
		return studentDao;
	}
	
}
