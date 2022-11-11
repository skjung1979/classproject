package com.firstcoding.firstapp.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;

public class ConnectionUtil {

    // POOL: 데이터베이스 연결정보를 가지고 설정값에 따라 Connection객체를 생성해서 관리(가지고 있다가 필요한 곳에 준다)한다.
    // 이제는 ConnectionProvider를 만들지 않고, 이렇게 설정하여 DB를 연결한다.
    private HikariDataSource ds; // 연결 정보(connection)를 갖고 있다.

    private static ConnectionUtil instance = new ConnectionUtil();

    private ConnectionUtil(){

        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3307/project");
        config.setUsername("scott");
        config.setPassword("tiger");
        config.addDataSourceProperty("cachePrepStmts", true);
        config.addDataSourceProperty("prepStmtCacheSize", 250);
        config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);

        ds = new HikariDataSource(config);

    }

    public static ConnectionUtil getInstance(){
        return instance;
    }

    public Connection getConnection() throws Exception{
        return ds.getConnection();
    }

}
