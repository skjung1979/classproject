package com.todo.todo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

/*
    private Connection conn;
    private ConnectionProvider instance = new ConnectionProvider();
    private ConnectionProvider(){}

    public ConnectionProvider getInstance(){
        return instance;
    }
*/

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        // MyBatis로 변경하며, jdbc충돌 방지를 위해 주석 처리함

        // 예외 처리를 여기서 하지 않고, 메소드를 호출한 곳에서 처리하도록 던진다.
        // Class.forName("com.mysql.cj.jdbc.Driver"); // 이 라인은 생략해도 된다.

        // 예외 처리를 여기서 하지 않고, 메소드를 호출한 곳에서 처리하도록 던진다.
        // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project", "scott", "tiger");

        return null;
    }
}


