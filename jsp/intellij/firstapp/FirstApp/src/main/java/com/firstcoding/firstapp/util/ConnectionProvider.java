package com.firstcoding.firstapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
/*
    private Connection conn;

    private static ConnectionProvider instance = new ConnectionProvider();
    private ConnectionProvider(){};

    public ConnectionProvider getInstance(){

        return instance;
    }*/

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project", "scott", "tiger");

        return conn;
    }

}
