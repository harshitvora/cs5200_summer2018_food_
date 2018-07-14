package edu.neu.cs5200.dao;

import edu.neu.cs5200.model.Manager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ManagerDao {

    private String CREATE_PERSON = "INSERT INTO person (firstName, lastName, username, password, email, dob) VALUES (?, ?, ?, ?, ?, ?)";
    private String CREATE_MANAGER = "INSERT INTO manager (personId, preferred_location, cc_number, cvv, expiry_mm, expiry_yy) VALUES (?, ?, ?, ?, ?, ?)";
    private String FIND_ALL_MANAGERS = "SELECT * FROM manager, person WHERE manager.personId = person.id";
    private String FIND_MANAGER_BY_ID = "SELECT * FROM manager, person WHERE manager.personId = person.id AND manager.id = ?";
    private String FIND_MANAGER_BY_USERNAME = "SELECT * FROM manager, person WHERE manager.personId = person.id AND person.username = ?";
    private String FIND_MANAGER_BY_CREDENTIALS = "SELECT * FROM manager, person WHERE manager.personId = person.id AND person.username = ? AND person.password = ?";
    private String UPDATE_MANAGER = "UPDATE manager SET preferred_location = ?, cc_number = ?, cvv = ?, expiry_mm = ?, expiry_yy = ? WHERE id = ?";
    private String UPDATE_PERSON = "UPDATE person SET firstName = ?, lastName = ?, username = ?, password = ?, email = ?, dob = ? WHERE id = (SELECT personId FROM manager WHERE id = ?)";
    private String DELETE_MANAGER = "DELETE FROM manager WHERE id = ?";

    public static ManagerDao instance = null;

    public static ManagerDao getInstance() {
        if (instance == null) {
            instance = new ManagerDao();
        }
        return instance;
    }

    private ManagerDao() {
    }

    public int createManager(Manager manager) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(CREATE_PERSON, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, manager.getFirstName());
            statement.setString(2, manager.getLastName());
            statement.setString(3, manager.getUsername());
            statement.setString(4, manager.getPassword());
            statement.setString(5, manager.getEmail());
            statement.setDate(6, manager.getDob());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            int personId = rs.getInt(1);

            statement = connection.prepareStatement(CREATE_MANAGER, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, personId);
            statement.executeUpdate();
            rs = statement.getGeneratedKeys();
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

    public Collection<Manager> findAllManagers() {
        List<Manager> managers = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(FIND_ALL_MANAGERS);
            results = statement.executeQuery();
            while (results.next()) {
                Manager manager = createManagerFromResultSet(results);
                managers.add(manager);
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
        return managers;
    }

    public Manager findManagerById(int managerId) {
        Manager manager = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(FIND_MANAGER_BY_ID);
            statement.setInt(1, managerId);
            results = statement.executeQuery();
            if (results.next()) {
                manager = createManagerFromResultSet(results);
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
        return manager;
    }

    public Manager findManagerByUsername(String username) {
        Manager manager = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(FIND_MANAGER_BY_USERNAME);
            statement.setString(1, username);
            results = statement.executeQuery();
            if (results.next()) {
                manager = createManagerFromResultSet(results);
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
        return manager;
    }

    public Manager findManagerByCredentials(String username, String password) {
        Manager manager = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(FIND_MANAGER_BY_CREDENTIALS);
            statement.setString(1, username);
            statement.setString(2, password);
            results = statement.executeQuery();
            if (results.next()) {
                manager = createManagerFromResultSet(results);
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
        return manager;
    }

    public int updateManager(int managerId, Manager manager) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(UPDATE_PERSON);
            statement.setString(1, manager.getFirstName());
            statement.setString(2, manager.getLastName());
            statement.setString(3, manager.getUsername());
            statement.setString(4, manager.getPassword());
            statement.setString(5, manager.getEmail());
            statement.setDate(6, manager.getDob());
            statement.setInt(7, managerId);
            result = statement.executeUpdate();

            statement = connection.prepareStatement(UPDATE_MANAGER);
//            statement.setString(1, manager.getPreferredLocation());
//            statement.setString(2, manager.getCcNumber());
//            statement.setString(3, manager.getCvv());
//            statement.setInt(4, manager.getExpiryMM());
//            statement.setInt(5, manager.getExpiryYY());
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

    public int deleteManager(int managerId) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(DELETE_MANAGER);
            statement.setInt(1, managerId);
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

    private Manager createManagerFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        String email = resultSet.getString("email");
        Date dob = resultSet.getDate("dob");
        int personId = resultSet.getInt("personId");
        return new Manager(id, firstName, lastName, username, password, email, dob, personId);
    }
}
