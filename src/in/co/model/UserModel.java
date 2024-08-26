package in.co.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.bean.RoleBean;
import in.co.bean.UserBean;
import in.co.exception.DuplicateRecordException;
import in.co.util.JDBCDataSource;

public class UserModel {
	
	public Integer nextPk() throws Exception {

		int pk = 0;

		Connection conn = in.co.util.JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("SELECT MAX (ID) FROM ST_USER");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

		}

		in.co.util.JDBCDataSource.closeConnection(conn);

		return pk + 1;
	}
	public void add(UserBean bean) throws Exception {
		UserBean existbean = findByfirstname(bean.getFirstname());
		if (existbean != null) {
			throw new DuplicateRecordException("Firstname is already exist");
		}
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("INSERT INTO ST_USER VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
		ps.setLong(1,nextPk());
		ps.setString(2,bean.getFirstname());
		ps.setString(3, bean.getLastname());
		ps.setString(4,bean.getLoginid());
		ps.setString(5,bean.getPassword());
		ps.setString(6,bean.getConfirmpassword());
		ps.setDate(7, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(8, bean.getMobileno());
		ps.setLong(9,bean.getRoleid());
		ps.setString(10, bean.getGender());
		ps.setString(11, bean.getCreatedBy());
		ps.setString(12,bean.getModifiedBy());
		ps.setTimestamp(13,bean.getCreatedDatetime());
		ps.setTimestamp(14, bean.getModifiedDatetime());
		int i= ps.executeUpdate();
		System.out.println("done");
		JDBCDataSource.closeConnection(conn);
				
	}
	public void update(UserBean bean) throws Exception {
		UserBean existbean = findByfirstname(bean.getFirstname());
		if (existbean != null) {
			throw new DuplicateRecordException("Firstname is already exist");
		}
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("UPDATE ST_USER SET FIRSTNAME=?, LASTNAME=?,LOGINID=?,PASSWORD=?,CONFIRM_PASSWORD=?,DOB=?,MOBILE_NO=?,ROLEID=?,GENDER=?,  CREATED_BY=?, MODIFIED_BY =?, CREATED_DATETIME=?, MODIFIED_DATETIME=? WHERE ID=?");
		ps.setString(1,bean.getFirstname());
		ps.setString(2, bean.getLastname());
		ps.setString(3,bean.getLoginid());
		ps.setString(4,bean.getPassword());
		ps.setString(5,bean.getConfirmpassword());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(7, bean.getMobileno());
		ps.setLong(8,bean.getRoleid());
		ps.setString(9, bean.getGender());
		ps.setString(10, bean.getCreatedBy());
		ps.setString(11,bean.getModifiedBy());
		ps.setTimestamp(12,bean.getCreatedDatetime());
		ps.setTimestamp(13, bean.getModifiedDatetime());
		ps.setLong(14,bean.getId());
		int i=ps.executeUpdate();
		System.out.println("done");
		JDBCDataSource.closeConnection(conn);
		}
	
	public void delete(long id) throws Exception {

		Connection conn = in.co.util.JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("DELETE FROM ST_USER WHERE ID = ?");

		ps.setLong(1, id);

		int i = ps.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("data deleted => " + i);

	}
	public UserBean findByPK( int id) throws Exception {
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM ST_USER WHERE ID=?");
		ps.setLong(1,id);
		ResultSet rs=ps.executeQuery();
		UserBean bean=null;
		while(rs.next()) {
			bean= new UserBean();
			bean.setId(rs.getLong(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setConfirmpassword(rs.getString(6));
			bean.setDob(rs.getDate(7));
			bean.setMobileno(rs.getString(8));
			bean.setRoleid(rs.getLong(9));
			bean.setGender(rs.getString(10));
			bean.setCreatedBy(rs.getString(11));
			bean.setModifiedBy(rs.getString(12));
			bean.setCreatedDatetime(rs.getTimestamp(13));
			bean.setModifiedDatetime(rs.getTimestamp(14));
		
		}
		JDBCDataSource.closeConnection(conn);
		return bean;	
	}
	public UserBean authenticate(String loginid,String password) throws Exception {
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM ST_USER WHERE LOGINID =? and PASSWORD=?");
		ps.setString(1, loginid);
		ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		UserBean bean=null;
		while(rs.next()) {
			bean.setId(rs.getLong(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setConfirmpassword(rs.getString(6));
			bean.setDob(rs.getDate(7));
			bean.setMobileno(rs.getString(8));
			bean.setRoleid(rs.getLong(9));
			bean.setGender(rs.getString(10));
			bean.setCreatedBy(rs.getString(11));
			bean.setModifiedBy(rs.getString(12));
			bean.setCreatedDatetime(rs.getTimestamp(13));
			bean.setModifiedDatetime(rs.getTimestamp(14));
			JDBCDataSource.closeConnection(conn);
		}
		return bean;
		
		}
	public UserBean findByfirstname(String firstname) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ST_USER WHERE FIRSTNAME=?");
		ps.setString(1,firstname);
		ResultSet rs = ps.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getLong(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setConfirmpassword(rs.getString(6));
			bean.setDob(rs.getDate(7));
			bean.setMobileno(rs.getString(8));
			bean.setRoleid(rs.getLong(9));
			bean.setGender(rs.getString(10));
			bean.setCreatedBy(rs.getString(11));
			bean.setModifiedBy(rs.getString(12));
			bean.setCreatedDatetime(rs.getTimestamp(13));
			bean.setModifiedDatetime(rs.getTimestamp(14));
		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}
	public  UserBean findByloginid(String loginid) throws Exception{
		Connection conn = in.co.util.JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ST_USER WHERE LOGINID=?");

		pstmt.setString(1, loginid);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getLong(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setConfirmpassword(rs.getString(6));
			bean.setDob(rs.getDate(7));
			bean.setMobileno(rs.getString(8));
			bean.setRoleid(rs.getLong(9));
			bean.setGender(rs.getString(10));
			bean.setCreatedBy(rs.getString(11));
			bean.setModifiedBy(rs.getString(12));
			bean.setCreatedDatetime(rs.getTimestamp(13));
			bean.setModifiedDatetime(rs.getTimestamp(14));
		}
		JDBCDataSource.closeConnection(conn);
		return bean;
		
	}
	public List search(UserBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = in.co.util.JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from st_user where 1=1");

		if (bean != null) {
			if (bean.getId()>0 ) {
				sql.append(" and id like '" + bean.getId() + "%'");
			}

			if (bean.getFirstname() != null && bean.getFirstname().length() > 0) {
				sql.append(" and first_name like '" + bean.getFirstname() + "%'");
			}
			if (bean.getLastname() != null && bean.getLastname().length() > 0) {
				sql.append(" and last_name like '" + bean.getLastname() + "%'");
			}
			if (bean.getLoginid() != null && bean.getLoginid().length() > 0) {
				sql.append(" and loginid_name like '" + bean.getLoginid() + "%'");
			}
			if (bean.getPassword() != null && bean.getPassword().length() > 0) {
				sql.append(" and password_name like '" + bean.getPassword() + "%'");
			}
			if (bean.getDob() != null && bean.getDob().getTime() > 0) {
				sql.append(" and dob like '" + new java.sql.Date(bean.getDob().getTime()) + "%'");
			}
			if (bean.getMobileno() != null && bean.getMobileno().length() > 0) {
				sql.append(" and first_name like '" + bean.getMobileno() + "%'");
			}
			if (bean.getGender() != null && bean.getGender().length() > 0) {
				sql.append(" and first_name like '" + bean.getGender() + "%'");
			}



		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}
		List list = new ArrayList();
		System.out.println("sql ==>> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		
		while(rs.next()) {
			bean.setId(rs.getLong(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setConfirmpassword(rs.getString(6));
			bean.setDob(rs.getDate(7));
			bean.setMobileno(rs.getString(8));
			bean.setRoleid(rs.getLong(9));
			bean.setGender(rs.getString(10));
			bean.setCreatedBy(rs.getString(11));
			bean.setModifiedBy(rs.getString(12));
			bean.setCreatedDatetime(rs.getTimestamp(13));
			bean.setModifiedDatetime(rs.getTimestamp(14));
			list.add(bean);
			

}
		JDBCDataSource.closeConnection(conn);
		return list;
}
}
