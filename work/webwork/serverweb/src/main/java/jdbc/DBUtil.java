package jdbc;
/*
 * 커넥션 설정과 자원 반납 등 모든 메소드가 공통으로 처리하는 부분을 구현
 * 1. 드라이버 로딩
 * 2. DB서버 연결
 * 3. 자원반납
 * static을 활용
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	// 드라이버 로딩
	// => 클래스가 로딩될 떄 한 번 실행된다.
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// DB 서버 연결 - DB서버 연결하고 커넥션 객체를 리턴
	public static Connection getConnect() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	// 자원반납을 위한 메소드
	public static void close(ResultSet rs, Statement stmt, Connection con) {
		try {
			if (rs!=null)rs.close();
			if (stmt!=null)stmt.close();
			if (con!=null)con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
