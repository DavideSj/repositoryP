package model;


import model.User;


import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class UserDao implements UserI {
	static Connection connection;
	static Statement stmt;
	static ResultSet rs;
	static PreparedStatement ps;

	private User extractUserFromResultSet(ResultSet rs) throws SQLException {

		User user = new User();

		user.setId(rs.getInt("id"));

		user.setEmail(rs.getString("Email"));

		user.setPassword(rs.getString("Password"));




		return user;

	}



	public boolean insertUser(User user) {


		connection = ConnectionFactory.getConnection();

		try {

			ps = connection.prepareStatement("INSERT INTO clienti VALUES (NULL, ?, ?)");

			ps.setString(1, user.getEmail());

			ps.setString(2, user.getPassword());



			int i = ps.executeUpdate();

			if (i == 1) {

				return true;

			}

		} catch (SQLException ex) {

			ex.printStackTrace();

		} finally
		{
			try {
				ConnectionFactory.close(connection);
				ConnectionFactory.close(ps);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;

	}

	public boolean loginUser(String email,String password) {

		connection = ConnectionFactory.getConnection();
		

		try {

			stmt = connection.createStatement();

			rs = stmt.executeQuery("SELECT * FROM clienti WHERE Email= '" + email+"' AND Password= '"+password+"'");


			if (rs.next()) {

				return true ;



			}

		} catch (SQLException ex) {

			ex.printStackTrace();

		} finally {
			try {
				ConnectionFactory.close(connection);
				ConnectionFactory.close(stmt);
				ConnectionFactory.close(rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}
	public User getUser(String email,String password) {

		connection = ConnectionFactory.getConnection();

		try {

			stmt = connection.createStatement();

			rs = stmt.executeQuery("SELECT * FROM clienti WHERE Email= '" + email+"' AND Password= '"+password+"'");


			if (rs.next()) {

				return extractUserFromResultSet(rs) ;



			}

		} catch (SQLException ex) {

			ex.printStackTrace();

		} finally {
			try {
				ConnectionFactory.close(connection);
				ConnectionFactory.close(stmt);
				ConnectionFactory.close(rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

}


