package user;

import java.sql.*;

public class UserDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public UserDAO(){
        try {

            String dbURL = "jdbc:mysql://localhost:3307/BBS";
            String dbID = "root";
            String dbPassword = "admin";
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
    }

    public int login(String userID, String userPassword){

        String SQL = "select userPassword from user where userID = ?";

        try{

            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID);
            rs = pstmt.executeQuery();
            
            if (rs.next()){
                
                if(rs.getString(1).equals(userPassword)){
                    return 1; // 로그인 성공
                } else {
                    return 0; // 비밀번호 불일치
                }
            } return -1; // 아이디가 없음

        } catch (Exception e){
            e.printStackTrace();
        }
        return -2; // 데이터베이스 오류

    }

}
