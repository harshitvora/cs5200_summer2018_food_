package edu.neu.cs5200.dao;

import java.sql.*;

public class DbUtil {
    public static final String URL = "jdbc:mysql://huskyeats.cnt6vkb3duoe.us-east-2.rds.amazonaws.com";
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "huskyeats123";

    public static Date getCurrentDate(){
        return new Date(new java.util.Date().getTime());
    }

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement("SELECT * FROM restaurant");
            result = statement.executeQuery();
            if(result.next()){
                System.out.println("test");
            }
            else {
                System.out.println("No test");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
