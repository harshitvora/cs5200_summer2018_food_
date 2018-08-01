package edu.neu.cs5200.dao;

import edu.neu.cs5200.entity.Restaurant;

import java.sql.*;

public class RestaurantDao {
    private String CREATE_RESTAURANT = "INSERT INTO restaurant (name, url, email) VALUES (?, ?, ?)";
    private String FIND_RESTAURANT_BY_ID = "SELECT * FROM restaurant WHERE id = ?";
    private String UPDATE_RESTAURANT = "UPDATE restaurant SET name = ?, url = ?, email = ? WHERE id = ?";
    private String DELETE_RESTAURANT = "DELETE FROM restaurant WHERE id = ?";

    public static RestaurantDao instance = null;

    public static RestaurantDao getInstance() {
        if (instance == null) {
            instance = new RestaurantDao();
        }
        return instance;
    }

    private RestaurantDao() {
    }

    public int createRestaurant(Restaurant restaurant) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(CREATE_RESTAURANT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, restaurant.getName());
            statement.setString(2, restaurant.getUrl());
            statement.setString(3, restaurant.getEmail());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            result = rs.getInt(1);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public Restaurant findRestaurantById(int restaurantId) {
        Restaurant restaurant = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(FIND_RESTAURANT_BY_ID);
            statement.setInt(1, restaurantId);
            rs = statement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("street1");
                String url = rs.getString("street2");
                String email = rs.getString("city");
                restaurant = new Restaurant(id, name, url, email);
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
        return restaurant;
    }

    public int updateRestaurant(int restaurantId, Restaurant restaurant) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(UPDATE_RESTAURANT);
            statement.setString(1, restaurant.getName());
            statement.setString(2, restaurant.getUrl());
            statement.setString(3, restaurant.getEmail());
            result = statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public int deleteRestaurant(int restaurantId) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(DELETE_RESTAURANT);
            statement.setInt(1, restaurantId);
            result = statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
