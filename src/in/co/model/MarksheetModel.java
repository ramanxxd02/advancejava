package in.co.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.bean.MarksheetBean;
import in.co.bean.RoleBean;
import in.co.college.CollegeBean;
import in.co.exception.DuplicateRecordException;
import in.co.util.JDBCDataSource;

public class MarksheetModel {
	public int nextpk() throws Exception {
		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement psmt = conn.prepareStatement("SELECT MAX (ID) FROM ST_MARKSHEET ");
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
			System.out.println("max id" + pk);

		}
		JDBCDataSource.closeConnection(conn);
		return pk + 1;
	}

	public void add(MarksheetBean bean) throws Exception {
		MarksheetBean existbean = findByRole(bean.getName());
		if (existbean != null) {
			throw new DuplicateRecordException("name is already exist");
		}
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement psmt = conn
				.prepareStatement("INSERT INTO ST_MARKSHEET VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		// psmt.setLong(1, nextpk());
		psmt.setLong(1, bean.getId());
		psmt.setString(2, bean.getRollNo());
		psmt.setLong(3, bean.getStudentId());
		psmt.setString(4, bean.getName());
		psmt.setInt(5, bean.getPhysics());
		psmt.setInt(6, bean.getChemistry());
		psmt.setInt(7, bean.getMaths());
		psmt.setString(8, bean.getCreatedBy());
		psmt.setString(9, bean.getModifiedBy());
		psmt.setTimestamp(10, bean.getCreatedDatetime());
		psmt.setTimestamp(11, bean.getModifiedDatetime());
		int i = psmt.executeUpdate();
		JDBCDataSource.closeConnection(conn);
		System.out.println("added successfully" + i);
	}

	public void update(MarksheetBean bean) throws Exception {
		MarksheetBean existbean = findByRole(bean.getName());
		if (existbean != null) {
			throw new DuplicateRecordException("Rolename is already exist");
		}
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"UPDATE ST_MARKSHEET SET ROLL_NO = ?, STUDENT_ID = ?, NAME = ?, PHYSICS = ?, CHEMISTRY = ?, MATHS = ?,  CREATED_BY = ?,  MODIFIED_BY = ?, CREATED_DATETIME = ?, MODIFIED_DATETIME = ? WHERE ID =?");

		ps.setString(1, bean.getRollNo());
		ps.setLong(2, bean.getStudentId());
		ps.setString(3, bean.getName());
		ps.setInt(4, bean.getPhysics());
		ps.setInt(5, bean.getChemistry());
		ps.setInt(6, bean.getMaths());
		ps.setString(7, bean.getCreatedBy());
		ps.setString(8, bean.getModifiedBy());
		ps.setTimestamp(9, bean.getCreatedDatetime());
		ps.setTimestamp(10, bean.getModifiedDatetime());
		ps.setLong(11, bean.getId());

		int i = ps.executeUpdate();
		JDBCDataSource.closeConnection(conn);
		System.out.println("update successfully" + i);

	}

	public void delete(MarksheetBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("DELETE FROM ST_MARKSHEET WHERE ID=? ");
		ps.setLong(1, bean.getId());
		int i = ps.executeUpdate();

		JDBCDataSource.closeConnection(conn);
		System.out.println("done");

	}
	public MarksheetBean findByPk(long id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM  ST_MARKSHEET WHERE ID=?");
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();

		MarksheetBean bean = null;
		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getLong(1));
			bean.setRollNo(rs.getString(2));
			bean.setStudentId(rs.getLong(3));
			bean.setName(rs.getString(4));
			bean.setPhysics(rs.getInt(5));
			bean.setChemistry(rs.getInt(6));
			bean.setMaths(rs.getInt(7));
			bean.setCreatedBy(rs.getString(8));
			bean.setModifiedBy(rs.getString(9));
			bean.setCreatedDatetime(rs.getTimestamp(10));
			bean.setModifiedDatetime(rs.getTimestamp(11));
		}
		JDBCDataSource.closeConnection(conn);

		return bean;

	}

	public List search(MarksheetBean bean, int pageNo, int pageSize) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_MARKSHEET WHERE 1=1");
		if (bean != null) {
			if (bean.getRollNo() != null && bean.getRollNo().length() > 0) {
				sql.append("and findRollNo" + bean.getRollNo() + "%");

			}

		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append("limit" + pageNo + "," + pageSize);

		}
		System.out.println("sql==>>" + sql.toString());

		PreparedStatement psmt = conn.prepareStatement(sql.toString());
		ResultSet rs = psmt.executeQuery();
		List list = new ArrayList();

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getLong(1));
			bean.setRollNo(rs.getString(2));
			bean.setStudentId(rs.getLong(3));
			bean.setName(rs.getString(4));
			bean.setPhysics(rs.getInt(5));
			bean.setChemistry(rs.getInt(6));
			bean.setMaths(rs.getInt(7));
			bean.setCreatedBy(rs.getString(8));
			bean.setModifiedBy(rs.getString(9));
			bean.setCreatedDatetime(rs.getTimestamp(10));
			bean.setModifiedDatetime(rs.getTimestamp(11));
			list.add(bean);
		}
		JDBCDataSource.closeConnection(conn);
		return list;

	}

	public MarksheetBean findByRole(String Name) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ST_MARKSHEET WHERE NAME=?");
		ps.setString(1, Name);
		ResultSet rs = ps.executeQuery();
	MarksheetBean bean = null;
		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getLong(1));
			bean.setRollNo(rs.getString(2));
			bean.setStudentId(rs.getLong(3));
			bean.setName(rs.getString(4));
			bean.setPhysics(rs.getInt(5));
			bean.setChemistry(rs.getInt(6));
			bean.setMaths(rs.getInt(7));
			bean.setCreatedBy(rs.getString(8));
			bean.setModifiedBy(rs.getString(9));
			bean.setCreatedDatetime(rs.getTimestamp(10));
			bean.setModifiedDatetime(rs.getTimestamp(11));

		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}
}
