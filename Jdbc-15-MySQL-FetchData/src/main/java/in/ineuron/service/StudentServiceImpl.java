package in.ineuron.service;

import java.util.List;

import in.ineuron.dao.StudentDao;
import in.ineuron.factory.StudentDaoFactory;
import in.ineuron.model.Student;

public class StudentServiceImpl implements IStudentService {

	private StudentDao dao;

	@Override
	public List<Student> detailsOfAllStudents() {

		dao = StudentDaoFactory.getStudentDao();

		return dao.detailsOfAllStudents();
	}

}
