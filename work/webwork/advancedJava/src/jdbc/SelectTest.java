package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest {
	public static void main(String[] args) {


		SelectTest obj = new SelectTest();
		String sql = "select * from member";
		obj.SelectTest2(sql);
	
	}
	public void SelectTest2(String sql) {
		
		try {

			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user = "scott";
			String password = "tiger";

			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("test1");
			
			// 2. 커넥션 생성
			Connection con = DriverManager.getConnection(url,user,password);
			System.out.println("test2");
			
			// 3. SQL문을 실행하기 위한 객체 만들기
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			System.out.println("test3");
			
			// 4. SQL문을 실행
			ResultSet result = stmt.executeQuery();

			// 5. 결과처리
			while (result.next()) {
				System.out.print(result.getString("id") + "\t");
				System.out.print(result.getString("pass") + "\t");
				System.out.print(result.getString("name") + "\t");
				System.out.print(result.getString("addr") + "\t");
				System.out.print(result.getDate("regdate") + "\t");
				System.out.print(result.getInt("point") + "\t");
				System.out.println(result.getString(7) + "\t");
			}
			
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
