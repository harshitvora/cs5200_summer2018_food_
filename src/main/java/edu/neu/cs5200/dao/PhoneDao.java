package edu.neu.cs5200.dao;

import edu.neu.cs5200.entity.Phone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneDao {
    private String CREATE_PHONE = "INSERT INTO phone (phone, primary, personId) VALUES (?, ?, ?)";
    private String FIND_PHONE_BY_PERSON_ID = "SELECT * FROM phone WHERE phone.personId = ?";
    private String FIND_PHONE_BY_ID = "SELECT * FROM phone WHERE id = ?";
    private String UPDATE_PHONE = "UPDATE phone SET phone = ?, primary = ? WHERE id = ?";
    private String DELETE_PHONE = "DELETE FROM phone WHERE id = ?";

    public static PhoneDao instance = null;

    public static PhoneDao getInstance() {
        if (instance == null) {
            instance = new PhoneDao();
        }
        return instance;
    }

    private PhoneDao() {
    }

    public int createPhone(Phone phone, int personId) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(CREATE_PHONE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, phone.getPhoneNumber());
            statement.setBoolean(2, phone.isPrimary());
            statement.setInt(3, personId);
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

    public Phone findPhoneById(int phoneId) {
        Phone phone = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(FIND_PHONE_BY_ID);
            statement.setInt(1, phoneId);
            rs = statement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String phoneNumber = rs.getString("phone");
                boolean primary = rs.getBoolean("primary");
                int personId = rs.getInt("personId");
                phone = new Phone(phoneNumber, primary, personId);
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
        return phone;
    }

    public List<Phone> findPhonesByPersonId(int personId) {
        List<Phone> phones = new ArrayList<>();
        Phone phone = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(FIND_PHONE_BY_PERSON_ID);
            statement.setInt(1, personId);
            rs = statement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String phoneNumber = rs.getString("phone");
                boolean primary = rs.getBoolean("primary");
                personId = rs.getInt("personId");
                phones.add(new Phone(phoneNumber, primary, personId));
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
        return phones;
    }

    public int updatePhone(int phoneId, Phone phone) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(UPDATE_PHONE);
            statement.setString(1, phone.getPhoneNumber());
            statement.setBoolean(2, phone.isPrimary());
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

    public int deletePhone(int phoneId) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbUtil.URL, DbUtil.USERNAME, DbUtil.PASSWORD);
            statement = connection.prepareStatement(DELETE_PHONE);
            statement.setInt(1, phoneId);
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
