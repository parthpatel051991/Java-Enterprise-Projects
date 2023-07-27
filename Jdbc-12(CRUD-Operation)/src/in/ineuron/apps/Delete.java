package in.ineuron.apps;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class Delete{

	public static void deleteApp() {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Student id :: ");
		int sid = scanner.nextInt();

		String deleteQuery = "delete from student where sid=? ";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(deleteQuery);
			}

			if (pstmt != null) {

				pstmt.setInt(1, sid);

				int noOfRowsUpdated = pstmt.executeUpdate();

				if (noOfRowsUpdated == 0) {

					System.out.println("Record is not found for  id : " + sid);
				} else {
					System.out.println("No of rows deleted:: " + noOfRowsUpdated);
					System.out.println("Success. Your data has been deleted permanently ");
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
