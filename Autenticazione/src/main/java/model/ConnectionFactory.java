package model;



import com.mysql.jdbc.Driver;

import java.sql.*;


public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://localhost:3306/clientisocial2";

    public static final String USER = "root";

    public static final String PASS = "";

    public static Connection getConnection() {

        try {

            DriverManager.registerDriver(new Driver());

            return DriverManager.getConnection(URL, USER, PASS);

        } catch (SQLException ex) {

            throw new RuntimeException("Error connecting to the database", ex);

        }

    }

    static public void close(ResultSet resultSet) throws SQLException {

        resultSet.close();

    }

    static public void close(Statement statement) throws SQLException {
        statement.close();

    }

    static public void close(PreparedStatement statement) throws SQLException {

        statement.close();

    }

    static public void close(Connection connection) throws SQLException {

        connection.close();


    }


}