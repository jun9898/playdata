package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//member테이블에 대한 CLRUD(CRUD)메소드를 정의
public class DeptMemberDAO {

	//select
	public void select() {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from mydept");
		try {
			con =  DeptDBUtil.getConnect();
			ptmt =  con.prepareStatement(sql.toString());
			rs = ptmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("deptno")+"\t");
				System.out.print(rs.getString("deptname")+"\t");
				System.out.print(rs.getString("tel")+"\t");
				System.out.print(rs.getString("addr")+"\t");
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DeptDBUtil.close(rs, ptmt, con);
		}
	}

	//delete
	public int delete(String deptno) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from mydept ");
		sql.append("where deptno=?");
		int result = 0;
		Connection con = null;
		PreparedStatement ptmt = null;
		try {
			con =  DeptDBUtil.getConnect();
			ptmt =  con.prepareStatement(sql.toString());
			ptmt.setString(1, deptno);
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 삭제성공!!");
		}  catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DeptDBUtil.close(null, ptmt, con);
		}
		return result;
	}

	//insert
	public int insert(DeptMemberDTO member) {
		String sql = "insert into mydept values(?,?,?,?)";
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		try {
			con = DeptDBUtil.getConnect();
			ptmt =  con.prepareStatement(sql);
			ptmt.setString(1, member.getDeptno());
			ptmt.setString(2, member.getDeptname());
			ptmt.setString(4, member.getAddr());
			ptmt.setString(3, member.getTel());
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 삽입성공!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DeptDBUtil.close(null, ptmt, con);
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
	
	public ArrayList<DeptMemberDTO> getMemberList () {
		ArrayList<DeptMemberDTO> memberList = new ArrayList<DeptMemberDTO>();
		System.out.println("dao method test");
		DeptMemberDTO member = null;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from mydept");
		try {
			con =  DeptDBUtil.getConnect();
			ptmt =  con.prepareStatement(sql.toString());
			rs = ptmt.executeQuery();
			while(rs.next()) {
				member = new DeptMemberDTO(rs.getString("deptno"), rs.getString("deptname") , rs.getString("tel"), 
						rs.getString("addr"));
				memberList.add(member);
			}
			System.out.println("조회된 레코드의 갯수 : " + memberList.size());
		}  catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DeptDBUtil.close(rs, ptmt, con);
		}
	return memberList;
	}
}
