package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginTest {
	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		StringBuffer sql = new StringBuffer();
		sql.append("select * from member where id='hon' and pass='1234'");
		
		try {

			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("test1");
			
			// 2. 커넥션 생성
			Connection con = DriverManager.getConnection(url,user,password);
			System.out.println("test2");
			
			// 3. SQL문을 실행하기 위한 객체 만들기
			Statement stmt = con.createStatement();
			System.out.println("test3");
			
			// 4. SQL문을 실행
			ResultSet result = stmt.executeQuery(sql.toString());
			System.out.println("조회된 ResultSet 객체 : " + result);

			// 5. 결과처리
			// 만약 결과가 여러개가 나오면 맨 처음 조회된 값만 출력이 되는지
			if (result.next()) {
				System.out.print(result.getString("id") + "\t");
				System.out.print(result.getString("pass") + "\t");
				System.out.print(result.getString("name") + "\t");
				System.out.print(result.getString("addr") + "\t");
				System.out.print(result.getDate("regdate") + "\t");
				System.out.print(result.getInt("point") + "\t");
				System.out.println(result.getString(7) + "\t");
			} else {
				System.out.println("없음");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
