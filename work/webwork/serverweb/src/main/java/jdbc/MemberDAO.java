package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Member테이블에 대한 CLRUD (CRUD) 메소드를 정의
public class MemberDAO {
	
	// Login
	public void login(String id, String pass) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from member where id=? and pass=?");
		Connection con = null;
		PreparedStatement ptmt = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql.toString());
			ptmt.setString(1, id);
			ptmt.setString(2, pass);
			ResultSet result = ptmt.executeQuery();
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
	}
	
	// SelectTest
	public void SelectTest2(String sql) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet result = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql.toString());
			result = ptmt.executeQuery();
			while (result.next()) {
				System.out.print(result.getString("id") + "\t");
				System.out.print(result.getString("pass") + "\t");
				System.out.print(result.getString("name") + "\t");
				System.out.print(result.getString("addr") + "\t");
				System.out.print(result.getDate("regdate") + "\t");
				System.out.print(result.getInt("point") + "\t");
				System.out.println(result.getString(7) + "\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(result, ptmt, con);
		}

		
	}
	
	// DeleteTest
	public void DeleteTest2(String id) {
		
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM MEMBER WHERE ID=?");
		
		Connection con = null;
		PreparedStatement ptmt = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql.toString());
			ptmt.setString(1, id);
			int result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}

	}
	
	// UpdateTest
	public void UpdateTest2(String id,String addr) {
		
		String sql = "UPDATE MEMBER SET ADDR=? WHERE id=?";
		
		Connection con = null;
		PreparedStatement ptmt = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql.toString());
			ptmt.setString(1, addr);
			ptmt.setString(2, id);
			int result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}


	}


	// insert Test
	public void InsertTest2(String id, String pass,String name, String addr, String info) {

		String sql = "insert into member values(?,?,?,?,sysdate,1000,?)";
		
		Connection con = null;
		PreparedStatement ptmt = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql.toString());
			ptmt.setString(1, id);
			ptmt.setString(2, pass);
			ptmt.setString(3, name);
			ptmt.setString(4, addr);
			ptmt.setString(5, info);
			int result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}

	}
}
