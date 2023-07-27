package in.ineuron.apps;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.util.JdbcUtil;

public class Select {

	public static void selectApp() {
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;		
		String selectQuery = "select sid,sname,sage,saddress from student";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(selectQuery);
			}

			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
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
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
