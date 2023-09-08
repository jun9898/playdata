package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {
	public static void main(String[] args) {

		UpdateTest obj = new UpdateTest();
		Scanner key = new Scanner(System.in);
		System.out.print("아이디");
		String id = key.next();
		System.out.print("바뀔 주소:");
		String addr = key.next();
		obj.UpdateTest2(id, addr);
	}
		
	public void UpdateTest2(String id,String addr) {
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		String sql = "UPDATE MEMBER SET ADDR=? WHERE id=?";
		
		try {

			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("test1");
			
			// 2. 커넥션 생성
			Connection con = DriverManager.getConnection(url,user,password);
			System.out.println("test2");
			
			// 3. SQL문을 실행하기 위한 객체 만들기
			PreparedStatement stmt = con.prepareStatement(sql);
			System.out.println("test3");
			
			stmt.setString(1, addr);
			stmt.setString(2, id);
			
			// 4. SQL문을 실행
			int result = stmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
