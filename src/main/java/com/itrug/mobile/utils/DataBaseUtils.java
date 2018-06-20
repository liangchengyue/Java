package com.itrug.mobile.utils;

import java.sql.*;

public class DataBaseUtils {
    private static final String url = "jdbc:mysql://47.94.169.241:3306/mobile";
    private static final String username = "root";
    private static final String password = "zxx123456";
    private static Connection connection;


    public static void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DataBaseUtils.connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void destroyed() {
        closeConnection(connection);
    }

    public static Connection getConnection() {
        DataBaseUtils.init();
        return connection;
    }

    public static PreparedStatement getPreparedStatement(Connection connection, String sql, boolean isAutoGenKey) {
        PreparedStatement statement = null;
        if (null != connection) {
            try {
                if (isAutoGenKey) {
                    return connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                } else {
                    return connection.prepareStatement(sql);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return statement;
    }

    public static void closeConnection(Connection connection) {
        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(Statement statement) {
        if (null != statement) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
