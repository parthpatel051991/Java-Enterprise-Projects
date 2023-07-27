package in.ineuron.App;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.ineuron.util.JdbcUtil;

public class BatchUpdateApp {

	public static final String Insert_Query = "Insert into student(sname,sage,saddress)values(?,?,?)";


	public static void main(String[] args) {

		try (Connection connection = JdbcUtil.getJdbcConnection();
				PreparedStatement pstmt = connection.prepareStatement(Insert_Query);) {

			// Disable auto-commit to enable batch updates
			connection.setAutoCommit(false);

			// Read input data from a file
			BufferedReader reader = new BufferedReader(new FileReader(
					"C:\\Users\\cadet\\FinalAssignment\\Jdbc-13(Batch-Udate-PostgreSQL)\\src\\in\\ineuron\\resource\\input_data.txt"));

			String line;
			while ((line = reader.readLine()) != null) {

				// Split the line into columns (assuming comma-separated values)
				String[] columns = line.split(",");

				// Set values in the prepared statement
				pstmt.setString(1, columns[0]);
				pstmt.setInt(2, Integer.parseInt(columns[1]));
				pstmt.setString(3, columns[2]);

				// Add the statement to the batch
				pstmt.addBatch();
			}

			reader.close();

			// Execute the batch update

			int[] updateCount = pstmt.executeBatch();

			// Commit the Changes
			connection.commit();

			// Print the number of rows affected

			int totalRowsAffected = 0;

			// Print the number of rows affected
			for (int count : updateCount) {
				totalRowsAffected += count;
			}

			if (totalRowsAffected == 0) {
				System.out.println("Insertion operation failed");
			} else {

				System.out.println("Total rows Affected :: " + totalRowsAffected);
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
