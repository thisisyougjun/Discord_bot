package utill;

import java.sql.*;

public class JDBCUtil {
    public static Connection getConnection() {
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String password = "1234";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("드라이버 파일을 찾을 수 없습니다.");
            return null;
        }
        Connection con=null;

        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("DB 연결중 오류 발생");
        }
        return con;
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) rs.close();
        } catch (Exception e) {
        }
    }

    public static void close(PreparedStatement ps) {
        try {
            if (ps != null) ps.close();
        } catch (Exception e) {
        }
    }

    public static void close(Connection co) {
        try {
            if (co != null) co.close();
        } catch (Exception e) {}
    }
}

