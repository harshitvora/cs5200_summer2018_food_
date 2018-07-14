package edu.neu.cs5200.dao;

import edu.neu.cs5200.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerDao {

    private String CREATE_PERSON = "INSERT INTO person (firstName, lastName, username, password, email, dob) VALUES (?, ?, ?, ?, ?, ?)";
    private String CREATE_CUSTOMER = "INSERT INTO customer (personId, preferred_location, cc_number, cvv, expiry_mm, expiry_yy) VALUES (?, ?, ?, ?, ?, ?)";
    private String FIND_ALL_CUSTOMERS = "SELECT * FROM customer, person WHERE customer.personId = person.id";
    private String FIND_CUSTOMER_BY_ID = "SELECT * FROM customer, person WHERE customer.personId = person.id AND customer.id = ?";
    private String FIND_CUSTOMER_BY_USERNAME = "SELECT * FROM customer, person WHERE customer.personId = person.id AND person.username = ?";
    private String FIND_CUSTOMER_BY_CREDENTIALS = "SELECT * FROM customer, person WHERE customer.personId = person.id AND person.username = ? AND person.password = ?";
    private String UPDATE_CUSTOMER = "UPDATE customer SET preferred_location = ?, cc_number = ?, cvv = ?, expiry_mm = ?, expiry_yy = ? WHERE id = ?";
    private String UPDATE_PERSON = "UPDATE person SET firstName = ?, lastName = ?, username = ?, password = ?, email = ?, dob = ? WHERE id = (SELECT personId FROM customer WHERE id = ?)";
    private String DELETE_CUSTOMER = "DELETE FROM customer WHERE id = ?";

    public static CustomerDao instance = null;

    public static CustomerDao getInstance() {
        if (instance == null) {
            instance = new CustomerDao();
        }
        return instance;
    }

    private CustomerDao() {
    }

    public int createCustomer(Customer customer) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(CREATE_PERSON, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getUsername());
            statement.setString(4, customer.getPassword());
            statement.setString(5, customer.getEmail());
            statement.setDate(6, customer.getDob());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            int personId = rs.getInt(1);

            statement = connection.prepareStatement(CREATE_CUSTOMER, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, personId);
            statement.setString(2, customer.getPreferredLocation());
            statement.setString(3, customer.getCcNumber());
            statement.setString(4, customer.getCvv());
            statement.setInt(5, customer.getExpiryMM());
            statement.setInt(6, customer.getExpiryYY());
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

    public Collection<Customer> findAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(FIND_ALL_CUSTOMERS);
            results = statement.executeQuery();
            while (results.next()) {
                Customer customer = createCustomerFromResultSet(results);
                customers.add(customer);
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
        return customers;
    }

    public Customer findCustomerById(int customerId) {
        Customer customer = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(FIND_CUSTOMER_BY_ID);
            statement.setInt(1, customerId);
            results = statement.executeQuery();
            if (results.next()) {
                customer = createCustomerFromResultSet(results);
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
        return customer;
    }

    public Customer findCustomerByUsername(String username) {
        Customer customer = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(FIND_CUSTOMER_BY_USERNAME);
            statement.setString(1, username);
            results = statement.executeQuery();
            if (results.next()) {
                customer = createCustomerFromResultSet(results);
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
        return customer;
    }

    public Customer findCustomerByCredentials(String username, String password) {
        Customer customer = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(FIND_CUSTOMER_BY_CREDENTIALS);
            statement.setString(1, username);
            statement.setString(2, password);
            results = statement.executeQuery();
            if (results.next()) {
                customer = createCustomerFromResultSet(results);
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
        return customer;
    }

    public int updateCustomer(int customerId, Customer customer) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(UPDATE_PERSON);
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getUsername());
            statement.setString(4, customer.getPassword());
            statement.setString(5, customer.getEmail());
            statement.setDate(6, customer.getDob());
            statement.setInt(7, customerId);
            result = statement.executeUpdate();

            statement = connection.prepareStatement(UPDATE_CUSTOMER);
            statement.setString(1, customer.getPreferredLocation());
            statement.setString(2, customer.getCcNumber());
            statement.setString(3, customer.getCvv());
            statement.setInt(4, customer.getExpiryMM());
            statement.setInt(5, customer.getExpiryYY());
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

    public int deleteCustomer(int customerId) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(DELETE_CUSTOMER);
            statement.setInt(1, customerId);
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

    private Customer createCustomerFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        String email = resultSet.getString("email");
        Date dob = resultSet.getDate("dob");
        String preferredLocation = resultSet.getString("preferred_location");
        String ccNumber = resultSet.getString("cc_number");
        String cvv = resultSet.getString("cvv");
        int expiryMM = resultSet.getInt("expiry_mm");
        int expiryYY = resultSet.getInt("expiry_yy");
        int personId = resultSet.getInt("personId");
        return new Customer(id, firstName, lastName, username, password, email, dob, preferredLocation, ccNumber, cvv, expiryMM, expiryYY, personId);
    }
}
