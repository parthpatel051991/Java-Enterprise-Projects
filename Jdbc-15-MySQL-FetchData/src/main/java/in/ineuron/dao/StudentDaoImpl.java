package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.ineuron.model.Student;
import in.ineuron.util.JdbcUtil;

public class StudentDaoImpl implements StudentDao {

	public static final String select_query = "select * from student";

	@Override
	public List<Student> detailsOfAllStudents() {

		System.out.println("StudentDaoImpl.detailsOfAllStudents()");

		List<Student> list = new ArrayList<>();

		try {
			Connection connection = JdbcUtil.getJdbcConnection();

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(select_query);

			while (resultSet.next()) {

				Student student = new Student();

				student.setSid(resultSet.getInt(1));
				student.setSname(resultSet.getString(2));
				student.setSage(resultSet.getInt(3));
				student.setSaddress(resultSet.getString(4));

				list.add(student);

			}

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
