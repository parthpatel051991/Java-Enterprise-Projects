package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.ineuron.model.Blog;
import in.ineuron.util.JdbcUtil;

public class UserDaoImpl implements IUserDao {

	@Override
	public boolean checkUserAuthentication(String username, String password) {

		final String select_sql = "SELECT * FROM user WHERE username= ? AND password = ?";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null) {
				preparedStatement = connection.prepareStatement(select_sql);

			}

			if (preparedStatement != null) {
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, password);
				resultSet = preparedStatement.executeQuery();

			}

			if (resultSet != null && (resultSet.next() && (resultSet.getString(2).equals(username)
					&& resultSet.getString(3).equalsIgnoreCase(password)))) {
				return true;

			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.cleanUp(connection, preparedStatement, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public int createUser(String username, String password) {

		final String insert_sql = "insert into user(`username`,`password`)values(?,?)";

		final String select_sql = "SELECT * FROM user WHERE username= ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement insert_pstmt=null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null) {
				preparedStatement = connection.prepareStatement(select_sql);

			}

			if (preparedStatement != null) {
				preparedStatement.setString(1, username);
				resultSet = preparedStatement.executeQuery();

			}

			if (resultSet != null && (resultSet.next() && resultSet.getString(2).equals(username))) {

				return -1;

			}else {
				insert_pstmt=connection.prepareStatement(insert_sql);
				if (insert_pstmt != null) {
					insert_pstmt.setString(1, username);
					insert_pstmt.setString(2, password);
					int rowsAffected = insert_pstmt.executeUpdate();
					
					if(rowsAffected==0) {
						return 0;
					}else {
						return rowsAffected;
					}

				}
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.cleanUp(connection, preparedStatement, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;
	}

	@Override
	public int createBlog(Blog blog) {
		

		final String insert_sql = "insert into blog(`title`,`description`,`content`)values(?,?,?)";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null) {
				preparedStatement = connection.prepareStatement(insert_sql);

			}

			if (preparedStatement != null) {
				preparedStatement.setString(1, blog.getTitle());
				preparedStatement.setString(2, blog.getDescription());
				preparedStatement.setString(3, blog.getContent());
				int rowsAffected = preparedStatement.executeUpdate();


				if(rowsAffected==0) {
					return 0;
				}else {
					return rowsAffected;
				}
			}

		

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.cleanUp(connection, preparedStatement, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;
	}
		

	@Override
	public List<Blog> showAllBlogs() {
		
		final String select_sql = "SELECT * FROM blog ";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<Blog> blogs = new ArrayList<>();

		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null) {
				preparedStatement = connection.prepareStatement(select_sql);

			}

			if (preparedStatement != null) {
				resultSet = preparedStatement.executeQuery();

			}
			

			if (resultSet != null){
				
			while (resultSet.next()) {
				Blog blog = new Blog();
				
				int blogId = resultSet.getInt(1);
				String title = resultSet.getString(2);
				String description = resultSet.getString(3);
				String content = resultSet.getString(4);
				
				blog.setBlogId(blogId);
				blog.setTitle(title);
				blog.setDescription(description);
				blog.setContent(content);
				
				blogs.add(blog);
				
			}
				

			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.cleanUp(connection, preparedStatement, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return blogs;
	
	}

}
