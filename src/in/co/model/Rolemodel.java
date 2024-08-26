package in.co.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import in.co.bean.RoleBean;
import in.co.exception.DuplicateRecordException;
import in.co.util.JDBCDataSource;

public class Rolemodel {

	ResourceBundle rb = ResourceBundle.getBundle("in.co.bundle.System");
	public int nextpk() throws Exception {
		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement psmt = conn.prepareStatement("SELECT MAX (ID) FROM ST_ROLE ");
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
			System.out.println("max id" + pk);

		}
		JDBCDataSource.closeConnection(conn);
		return pk + 1;
	}

	public void add(RoleBean bean) throws Exception {
		RoleBean existbean = findByRole(bean.getName());
		if (existbean != null) {
			throw new DuplicateRecordException("Rolename is already exist");
		}
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("INSERT INTO ST_COLLEGE VALUES (?, ?, ?, ?, ?, ?, ?)");
		ps.setLong(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setString(3, bean.getDiscription());
		ps.setString(4, bean.getCreatedBy());
		ps.setString(5, bean.getModifiedBy());
		ps.setTimestamp(6, bean.getCreatedDatetime());
		ps.setTimestamp(7, bean.getModifiedDatetime());
		int i = ps.executeUpdate();
		System.out.println("done");

		JDBCDataSource.closeConnection(conn);

	}

	public void update(RoleBean bean) throws Exception {
		RoleBean existbean = findByRole(bean.getName());
		if (existbean != null && bean.getId() != existbean.getId()) {
			throw new DuplicateRecordException("Rolename is already exist");
		}
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"UPDATE ST_ROLE SET NAME=?, DESCRIPTION=?, CREATED_BY=?, MODIFIED_BY =?, CREATED_DATETIME=?, MODIFIED_DATETIME=? WHERE ID=?");
		ps.setString(1, bean.getName());
		ps.setString(2, bean.getDiscription());
		ps.setString(3, bean.getCreatedBy());
		ps.setString(4, bean.getModifiedBy());
		ps.setTimestamp(5, bean.getCreatedDatetime());
		ps.setTimestamp(6, bean.getModifiedDatetime());
		ps.setLong(7, bean.getId());
		int i = ps.executeUpdate();
		System.out.println("done");

		JDBCDataSource.closeConnection(conn);
	}

	public void delete(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("DELETE FROM ST_ROLE WHERE ID=?");
		ps.setLong(1, id);
		int j = ps.executeUpdate();
		System.out.println("Done");

		JDBCDataSource.closeConnection(conn);

	}

	public List search(RoleBean bean, int pageno, int pagesize) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_ROLE WHERE 1=1");
		if (bean.getName() != null && bean.getName().length() > 0) {
			sql.append("and name like'" + bean.getName() + "%'");

		}
		if (bean.getDiscription() != null && bean.getDiscription().length() > 0) {
			sql.append(" and dob like '" + bean.getDiscription() + "%'");
		}
		if (pagesize > 0) {
			pageno = (pageno - 1) * pagesize;
			sql.append(" limit " + pageno + ", " + pagesize);
		}

		System.out.println("sql ==>> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();
		while (rs.next()) {
			bean = new RoleBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDiscription(rs.getString(3));
			bean.setCreatedBy(rs.getString(4));
			bean.setModifiedBy(rs.getString(5));
			bean.setCreatedDatetime(rs.getTimestamp(6));
			bean.setModifiedDatetime(rs.getTimestamp(7));
			list.add(bean);
			System.out.println("done");

		}
		JDBCDataSource.closeConnection(conn);
		return list;
	}

	public RoleBean findByPK(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ST_ROLE WHERE ID=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		RoleBean bean = null;
		while (rs.next()) {
			bean = new RoleBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDiscription(rs.getString(3));
			bean.setCreatedBy(rs.getString(4));
			bean.setModifiedBy(rs.getString(5));
			bean.setCreatedDatetime(rs.getTimestamp(6));
			bean.setModifiedDatetime(rs.getTimestamp(7));

		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}

	public RoleBean findByRole(String roleName) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ST_ROLE WHERE NAME=?");
		ps.setString(1, roleName);
		ResultSet rs = ps.executeQuery();
		RoleBean bean = null;
		while (rs.next()) {
			bean = new RoleBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDiscription(rs.getString(3));
			bean.setCreatedBy(rs.getString(4));
			bean.setModifiedBy(rs.getString(5));
			bean.setCreatedDatetime(rs.getTimestamp(6));
			bean.setModifiedDatetime(rs.getTimestamp(7));

		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}

}
