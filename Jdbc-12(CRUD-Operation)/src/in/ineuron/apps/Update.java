package in.ineuron.apps;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class Update {

	public static void updateApp() {
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;	
		
        Scanner scanner = new Scanner(System.in);
		
        System.out.print("Enter Student id :: ");
        int sid = scanner.nextInt();
        
        
		System.out.print("Enter Student Name :");
		String sname = scanner.next();

		System.out.print("Enter Student Age :");
		int sage = scanner.nextInt();

		System.out.print("Enter Student City :");
		String saddr = scanner.next();
		
		
		
		String updateQuery = "update student set sname=?,sage=?,saddress=? where sid=? ";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(updateQuery);
			}

			if (pstmt != null) {
				
				pstmt.setString(1, sname);
				pstmt.setInt(2, sage);
				pstmt.setString(3, saddr);
				pstmt.setInt(4, sid);
				
				
				
				
				int noOfRowsUpdated = pstmt.executeUpdate();
				
				if (noOfRowsUpdated==0) {
					System.out.println("Record is not found for id : " + sid);
					
				} else {
					System.out.println("No of rows affected :: "+noOfRowsUpdated );
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
