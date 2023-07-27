package in.ineuron.factory;

import in.ineuron.service.IStudentService;
import in.ineuron.service.StudentServiceImpl;

public class StudentServiceFactory {

	private StudentServiceFactory() {}
	
	private static IStudentService service=null;
	
	public static IStudentService getStudentService() {
		
		if(service==null) {
			service=new StudentServiceImpl();
		}
		
		
		return service;
	}
}
