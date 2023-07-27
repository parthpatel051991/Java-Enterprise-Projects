package in.ineuron.apps;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class Insert {

	public static void insertApp() {
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;	
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Student Name :");
		String sname = scanner.next();

		System.out.print("Enter Student Age :");
		int sage = scanner.nextInt();

		System.out.print("Enter Student City :");
		String saddr = scanner.next();
		
		
		String insertQuery = "insert into student (`sname`,`sage`,`saddress`)values(?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(insertQuery);
			}

			if (pstmt != null) {
				
				pstmt.setString(1,sname);
				pstmt.setInt(2, sage);
				pstmt.setString(3,saddr);
				
				
				int noOfRowsUpdated = pstmt.executeUpdate();
				
				if (noOfRowsUpdated!=0) {
					System.out.println("No of rows affected :: "+noOfRowsUpdated );
					
				} else {
					System.out.println("Insertion of record is failed");
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
