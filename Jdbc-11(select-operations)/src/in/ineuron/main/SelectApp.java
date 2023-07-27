package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.ineuron.util.JdbcUtil;

public class SelectApp {

	public static void main(String[] args) {
		
		Connection connection=null;
		Statement statement =null;
		ResultSet resultSet=null;		
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				statement = connection.createStatement();
			}

			if (statement != null) {
				String selectQuery = "select sid,sname,sage,saddress from student";
				resultSet = statement.executeQuery(selectQuery);
			}
			
			if (resultSet!=null) {
				
				System.out.printf("%-2s%14s%12s%15s","SID","SNAME","SAGE","SADDRESS");
				System.out.println();
				
				while (resultSet.next()) {
					System.out.printf("%-2s%14s%12s%15s",resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4));
					System.out.println();
					
				}
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.cleanUp(connection, statement, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
