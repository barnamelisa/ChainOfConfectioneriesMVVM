package com.example.tema2_ps_final.model.connection;

import java.sql.*;

public class Connection {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/chain_of_confectioneries";
    private static final String USER = "root";
    private static final String PASS = "Melisa09.Barna2003!";
    private static Connection singleInstance = new Connection();

    private Connection() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            //   LOGGER.log(Level.SEVERE, "Driverul MySQL nu poate fi găsit!", e);
        }
    }

    private java.sql.Connection createConnection() {
        java.sql.Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (SQLException e) {
            //     LOGGER.log(Level.WARNING, "An error occured while trying to connect to the database");
            //  e.printStackTrace();
        }
        return connection;
    }

    public static java.sql.Connection getConnection() {
        return singleInstance.createConnection();
    }

    public static void close(java.sql.Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                //     LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
            }
        }
    }

    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                //   LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
            }
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                //   LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
            }
        }
    }
}