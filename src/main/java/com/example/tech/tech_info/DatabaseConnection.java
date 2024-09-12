package com.example.tech.tech_info;

import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:sqlitTest/customers";

    public static Connection getConnection() throws SQLException {
        System.out.println("Connecting to database at: " + URL);
        return DriverManager.getConnection(URL);
    }

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM customers")) {

            while (resultSet.next()) {
                String Id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                Integer mobile = resultSet.getInt("mobile");
                Double payment = resultSet.getDouble("payment");
                System.out.println("Id: " + Id);
                System.out.println("Name: " + name);
                System.out.println("Address: " + address);
                System.out.println("Mobile: " + mobile);
                System.out.println("Payment: " + payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

