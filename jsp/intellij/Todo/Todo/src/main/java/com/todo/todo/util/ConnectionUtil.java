package com.todo.todo.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;

public class ConnectionUtil {

    private HikariDataSource ds; // 아래와 같은 DB 연결 정보를 가지고 있는 객체이다.
    // "jdbc:mysql://localhost:3307/project", "scott", "tiger"
    // ConnectionProvider 객체를 생성할 필요 없이 히카리 데이터 소스를 통해 DB를 연결한다.

    private static ConnectionUtil instance = new ConnectionUtil();

    // Pool: 데이터 베이스 연결 정보를 가지고 설정값에 따라 Connection객체를 생성해서 가지고 관리한다.
    // 생성자
    private ConnectionUtil(){
        // config를 통해서 히카리 데이터 소소를 만들어 사용하게 된다.
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

    public Connection getConnection() throws Exception{
        return ds.getConnection();
    }

    public static ConnectionUtil getInstance(){
        return instance;
    }
    // 외부에서 커넥션유틸 객체를 ConnectionUtil.getInstance().getConnection()으로 호출하면,
    // getInsrance()메소드로 들어가 instance를 리턴 받고, getConnection()으로 가서 히카리 데이터 베이스 연결정보를 리턴받게 된다.

}
