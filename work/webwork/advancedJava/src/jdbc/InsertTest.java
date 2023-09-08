package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {
	public static void main(String[] args) {
		
		InsertTest obj = new InsertTest();
		Scanner key = new Scanner(System.in);
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("패스워드:");
		String pass = key.next();
		System.out.print("성명:");
		String name = key.next();
		System.out.print("주소:");
		String addr = key.next();
		System.out.print("기타:");
		String info = key.next();

		obj.InsertTest2(id,pass,name,addr,info);
	}

	public void InsertTest2(String id, String pass,String name, String addr, String info) {

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		String sql = "insert into member values(?,?,?,?,sysdate,1000,?)";
		
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. 커넥션 생성
			Connection con = DriverManager.getConnection(url,user,password);
			
			// 3. SQL문을 실행하기 위한 객체 만들기
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, id);
			stmt.setString(2, pass);
			stmt.setString(3, name);
			stmt.setString(4, addr);
			stmt.setString(5, info);

			// 4. SQL문을 실행
			int result = stmt.executeUpdate();
			
			// 5. 결과처리
			System.out.println(result + "개 행 삽입성공");
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
}
