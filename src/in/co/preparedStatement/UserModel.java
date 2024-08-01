package in.co.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
	// add krne ke liye

	public void add(Userbean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "Root");
		PreparedStatement pstmt = conn.prepareStatement("insert into workers values(?,?,?,?)");
		pstmt.setInt(1, nextPk());
		pstmt.setString(2, bean.getName());
		pstmt.setString(3, bean.getPost());
		pstmt.setInt(4, bean.getSalary());
		
		
		int i = pstmt.executeUpdate();
		System.out.println("done"+i);

	}

	// update krne ke liye

	public void update(Userbean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "Root");
		PreparedStatement pstmt = conn.prepareStatement("update workers set name=?,post=?,salary=? where id=?");
		pstmt.setString(1, bean.getName());
		pstmt.setString(2, bean.getPost());
		pstmt.setInt(3, bean.getSalary());
		pstmt.setInt(4, bean.getId());
		int i = pstmt.executeUpdate();
		System.out.println("done");
	}

	// delete krne ke liye
	public void delete(Userbean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "Root");
		PreparedStatement pstmt = conn.prepareStatement("delete from workers where id=?");
		pstmt.setInt(1, bean.getId());
		int i = pstmt.executeUpdate();
		System.out.println("done");
	}

	// id no automatic number vise add hote jayenge
	public int nextPk() throws Exception {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Company", "root", "Root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from Workers");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

			System.out.println("max id = " + pk);

		}
		return pk + 1;
	}

//	public Userbean findbyid(int id) throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "Root");
//		PreparedStatement pstmt = conn.prepareStatement("select*from workers where id=?");
//		pstmt.setInt(1, id);
//		ResultSet rs = pstmt.executeQuery();
//		Userbean bean = null;
//		while (rs.next()) {
//			bean = new Userbean();
//			bean.setId(rs.getInt(1));
//			bean.setName(rs.getString(2));
//			bean.setPost(rs.getString(3));
//			bean.setSalary(rs.getInt(4));
//		}
//		return bean;
//
//	}

	public List search(Userbean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "Root");
		StringBuffer sb = new StringBuffer("select*from workers where 1=1");
		if (bean != null) {
			if (bean.getName() != null && bean.getName().length() > 0) {
				sb.append(" and name like '" + bean.getName()+"'");
			}
		}
		System.out.println("sb query=====>" + sb.toString());
		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		ResultSet rs = pstmt.executeQuery();
		List list = new ArrayList();
		while (rs.next()) {
			bean = new Userbean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setPost(rs.getString(3));
			bean.setSalary(rs.getInt(4));

			list.add(bean);
		}
		return list;

	}

}
