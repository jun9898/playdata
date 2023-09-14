package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import basic.MemberDTO;

//member테이블에 대한 CLRUD(CRUD)메소드를 정의
public class MemberDAO {
	//login
	public MemberDTO login(String id,String pass) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from member where id=? and pass=?");
		MemberDTO member = null;
		try {
			con =  DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql.toString());
			ptmt.setString(1, id); //1번 ?
			ptmt.setString(2, pass);
			rs = ptmt.executeQuery();
			if(rs.next()) {
				 member = new MemberDTO(rs.getString("id"), rs.getString("pass") , rs.getString("name"), 
								rs.getString("addr"), rs.getDate("regdate"), rs.getInt("point"),
								rs.getString(7));
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return member;
	}

	//select
	public void select() {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from member");
		try {
			con =  DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql.toString());
			rs = ptmt.executeQuery();

			while(rs.next()) {
				System.out.print(rs.getString("id")+"\t");
				System.out.print(rs.getString("pass")+"\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getString("addr")+"\t");
				System.out.print(rs.getDate("regdate")+"\t");
				System.out.print(rs.getInt("point")+"\t");
				System.out.println(rs.getString(7)+"\t");
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
	}
	//delete
	public int delete(String id) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from member ");
		sql.append("where id=?");
		int result = 0;
		Connection con = null;
		PreparedStatement ptmt = null;
		try {
			con =  DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql.toString());
			ptmt.setString(1, id);
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 삭제성공!!");
		}  catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	//update
	public void update(String addr,String id) {
		String sql = "update member ";
		sql = sql+ "set addr=? ";
		sql = sql + "where id=?";
		Connection con = null;
		PreparedStatement ptmt = null;
		try {
			con =  DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql);
			ptmt.setString(1, addr);
			ptmt.setString(2, id);
			int result = ptmt.executeUpdate();
			System.out.println(result+"개 행 수정성공!!");
		}  catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
	}
	//insert
	public int insert(MemberDTO member) {
		String sql = "insert into member values(?,?,?,?,sysdate,10000,?)";
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		try {
			con = DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql);
			ptmt.setString(1, member.getId());
			ptmt.setString(2, member.getPass());
			ptmt.setString(3, member.getName());
			ptmt.setString(4, member.getAddr());
			ptmt.setString(5, member.getInfo());
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 삽입성공!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	//insert
//	public int insert(String id,String pass,String name,String addr,String info) {
//		String sql = "insert into member values(?,?,?,?,sysdate,10000,?)";
//		Connection con = null;
//		PreparedStatement ptmt = null;
//		int result = 0;
//		try {
//			con = DBUtil.getConnect();
//			ptmt =  con.prepareStatement(sql);
//			ptmt.setString(1, id);
//			ptmt.setString(2, pass);
//			ptmt.setString(3, name);
//			ptmt.setString(4, addr);
//			ptmt.setString(5, info);
//			result = ptmt.executeUpdate();
//			System.out.println(result+"개 행 삽입성공!!");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			DBUtil.close(null, ptmt, con);
//		}
//		return result;
//	}
	
	public ArrayList<MemberDTO> getMemberList () {
		ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();
		System.out.println("dao method test");
		MemberDTO member = null;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from member");
		try {
			con =  DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql.toString());
			rs = ptmt.executeQuery();
			while(rs.next()) {
				member = new MemberDTO(rs.getString("id"), rs.getString("pass") , rs.getString("name"), 
						rs.getString("addr"), rs.getDate("regdate"), rs.getInt("point"),
						rs.getString(7));
				memberList.add(member);
			}
			System.out.println("조회된 레코드의 갯수 : " + memberList.size());
		}  catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
	return memberList;
	}

	//search
	public ArrayList<MemberDTO> search(String addr) {
		ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from member where addr like ?");
		try {
			con =  DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql.toString());
			ptmt.setString(1, "%"+addr+"%");
			rs = ptmt.executeQuery();
			while(rs.next()) {
				member = new MemberDTO(rs.getString("id"), rs.getString("pass") , rs.getString("name"), 
						rs.getString("addr"), rs.getDate("regdate"), rs.getInt("point"),
						rs.getString(7));
				memberList.add(member);
			}
			System.out.println("조회된 레코드의 갯수 : " + memberList.size());
		}  catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
	return memberList;
	}
}