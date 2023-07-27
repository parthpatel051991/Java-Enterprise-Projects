package in.ineuron.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {

	private JdbcUtil() {
		
	}
	
	
	public static Connection getJdbcConnection() throws IOException, SQLException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\cadet\\FinalAssignment\\Jdbc-12(CRUD-Operation)\\src\\in\\ineuron\\resource\\application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"), properties.getProperty("password"));
		
		System.out.println("Connection object is created");
		
		
		return connection;
	}
	
	public static void cleanUp(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet) throws SQLException {
		
		if (connection!=null) {
			connection.close();
		}
		if (preparedStatement!=null) {
			preparedStatement.close();
		}
		if (resultSet!=null) {
			resultSet.close();
		}
	}
}
