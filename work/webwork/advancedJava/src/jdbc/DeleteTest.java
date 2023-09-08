package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest {
	public static void main(String[] args) {

		DeleteTest obj = new DeleteTest();
		Scanner key = new Scanner(System.in);
		System.out.print("아이디");
		String id = key.next();
		obj.DeleteTest2(id);
	}
		
	public void DeleteTest2(String id) {
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM MEMBER WHERE ID=?");
		
		try {

			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("test1");
			
			// 2. 커넥션 생성
			Connection con = DriverManager.getConnection(url,user,password);
			System.out.println("test2");
			
			// 3. SQL문을 실행하기 위한 객체 만들기
			PreparedStatement ptmt = con.prepareStatement(sql.toString());
			System.out.println("test3");
			
			ptmt.setString(1, id);
			
			// 4. SQL문을 실행
			int result = ptmt.executeUpdate();
			System.out.println("test4");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
