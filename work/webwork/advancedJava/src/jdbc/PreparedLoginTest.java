package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class PreparedLoginTest {
	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		PreparedLoginTest obj = new PreparedLoginTest();
		System.out.println("아이디 : ");
		String id = key.nextLine();
		System.out.println("패스워드 : ");
		String pass = key.nextLine();

		obj.login(id,pass);
	}

	public void login(String id, String pass) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		StringBuffer sql = new StringBuffer();
//		sql.append("select * from member where id='" + id + "' and pass='" + pass + "'");
//		1. sql문에서 외부에서 입력받을 부분은 ?로 표시
		sql.append("select * from member where id=? and pass=?");
		
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection(url,user,password);
			
			// 2. PreparedSTatement 객체를 생성 (sql을 전달)
			PreparedStatement ptmt = con.prepareStatement(sql.toString());
			
			// 3. ?에 대해서 값을 셋팅
			ptmt.setString(1, id);
			ptmt.setString(2, pass);
			
			// 4. sql문을 실행 - 메소드 호출할때 sql문을 빼고 호출
			ResultSet result = ptmt.executeQuery();

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
