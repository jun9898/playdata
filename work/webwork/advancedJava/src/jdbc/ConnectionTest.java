package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("test");
			
			Connection con = DriverManager.getConnection(url,user,password);
			System.out.println("연결성공 : " + con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
