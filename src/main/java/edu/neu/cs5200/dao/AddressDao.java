package edu.neu.cs5200.dao;

import edu.neu.cs5200.entity.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDao {
    private String CREATE_ADDRESS = "INSERT INTO address (street1, street2, city, state, zip, primary, personId) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private String FIND_ADDRESS_BY_PERSON_ID = "SELECT * FROM address WHERE address.personId = ?";
    private String FIND_ADDRESS_BY_ID = "SELECT * FROM address WHERE id = ?";
    private String UPDATE_ADDRESS = "UPDATE address SET street1 = ?, street2 = ?, city = ?, state = ?, zip = ?, primary = ? WHERE id = ?";
    private String DELETE_ADDRESS = "DELETE FROM address WHERE id = ?";

    public static AddressDao instance = null;

    public static AddressDao getInstance() {
        if (instance == null) {
            instance = new AddressDao();
        }
        return instance;
    }

    private AddressDao() {
    }

    public int createAddress(Address address, int personId) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(CREATE_ADDRESS, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, address.getStreet1());
            statement.setString(2, address.getStreet2());
            statement.setString(3, address.getCity());
            statement.setString(4, address.getState());
            statement.setString(5, address.getZip());
            statement.setBoolean(6, true);
            statement.setInt(7, personId);
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

    public Address findAddressById(int addressId) {
        Address address = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(FIND_ADDRESS_BY_ID);
            statement.setInt(1, addressId);
            rs = statement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String street1 = rs.getString("street1");
                String street2 = rs.getString("street2");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String zip = rs.getString("zip");
                boolean primary = rs.getBoolean("primary");
                int personId = rs.getInt("personId");
                address = new Address(street1, street2, city, state, zip, primary, personId);
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
        return address;
    }

    public List<Address> findAddressesByPersonId(int personId) {
        List<Address> addresses = new ArrayList<>();
        Address address = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(FIND_ADDRESS_BY_PERSON_ID);
            statement.setInt(1, personId);
            rs = statement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String street1 = rs.getString("street1");
                String street2 = rs.getString("street2");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String zip = rs.getString("zip");
                boolean primary = rs.getBoolean("primary");
                addresses.add(new Address(street1, street2, city, state, zip, primary, personId));
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
        return addresses;
    }

    public int updateAddress(int addressId, Address address) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(UPDATE_ADDRESS);
            statement.setString(1, address.getStreet1());
            statement.setString(2, address.getStreet2());
            statement.setString(3, address.getCity());
            statement.setString(4, address.getState());
            statement.setString(5, address.getZip());
            statement.setBoolean(6, address.isPrimary());
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

    public int deleteAddress(int addressId) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(DELETE_ADDRESS);
            statement.setInt(1, addressId);
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
