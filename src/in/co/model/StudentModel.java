package in.co.model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import in.co.bean.MarksheetBean;
import in.co.bean.RoleBean;
import in.co.bean.StudentBean;
import in.co.college.CollegeBean;
import in.co.exception.DuplicateRecordException;
import in.co.util.JDBCDataSource;

public class StudentModel {
	public int nextpk() throws Exception {
		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT MAX (ID) FROM ST_STUDENT ");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
			System.out.println("max id" + pk);

		}
		JDBCDataSource.closeConnection(conn);
		return pk + 1;
	}

	public void add(StudentBean bean) throws Exception {
		StudentBean existbean = findByRole(bean.getFirstName());
		if (existbean != null) {
			throw new DuplicateRecordException("Firstname is already exist");
		}
		
		CollegeModel collegeModel= new CollegeModel();
		CollegeBean collegeBean= collegeModel.findByPk(bean.getCollegeId());
		bean.setCollegeName(collegeBean.getName());
		
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO ST_STUDENT VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		ps.setLong(1, nextpk());
		// ps.setLong(1, bean.getId());
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setDate(4, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(5, bean.getGender());
		ps.setString(6, bean.getMobileNo());
		ps.setString(7, bean.getEmail());
		ps.setLong(8, bean.getCollegeId());
		ps.setString(9, bean.getCollegeName());
		ps.setString(10, bean.getCreatedBy());
		ps.setString(11, bean.getModifiedBy());
		ps.setTimestamp(12, new Timestamp(new Date().getTime()));
		ps.setTimestamp(13, new Timestamp(new Date().getTime()));
		int i = ps.executeUpdate();
		JDBCDataSource.closeConnection(conn);
		System.out.println("added successfully" + i);
	}

	public void update(StudentBean bean) throws Exception {
		StudentBean existbean = findByRole(bean.getFirstName());
		if (existbean != null) {
			throw new DuplicateRecordException("Firstname is already exist");
		}
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"UPDATE ST_STUDENT SET FIRST_NAME=?,LAST_NAME=?, DOB=?, GENDER=?, MOBILE_NO=?, EMAIL=?,  CREATED_BY=?, MODIFIED_BY =?, CREATED_DATETIME=?, MODIFIED_DATETIME=? WHERE ID=?");
		ps.setString(1, bean.getFirstName());
		ps.setString(2, bean.getLastName());
		ps.setDate(3, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(4, bean.getGender());
		ps.setString(5, bean.getMobileNo());
		ps.setString(6, bean.getEmail());
		ps.setLong(7, bean.getCollegeId());
		ps.setString(8, bean.getCollegeName());
		ps.setString(9, bean.getCreatedBy());
		ps.setString(10, bean.getModifiedBy());
		ps.setTimestamp(11, new Timestamp(new Date().getTime()));
		ps.setTimestamp(12, new Timestamp(new Date().getTime()));
		ps.setLong(13, bean.getId());
		int i = ps.executeUpdate();
		System.out.println("done");
		JDBCDataSource.closeConnection(conn);

	}

	public void delete(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("DELETE FROM ST_STUDENT WHERE ID =?");
		ps.setInt(1, id);
		int i = ps.executeUpdate();
		System.out.println("done");
		JDBCDataSource.closeConnection(conn);
	}

	public StudentBean getid(long id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ST_STUDENT WHERE ID =?");
		ps.setLong(1, id);

		ResultSet rs = ps.executeQuery();
		System.out.println("Done" + rs);
		StudentBean bean = null;
		while (rs.next()) {
			bean = new StudentBean();
			ps.setLong(1, bean.getId());
			ps.setString(2, bean.getFirstName());
			ps.setString(3, bean.getLastName());
			ps.setDate(4, new java.sql.Date(bean.getDob().getTime()));
			ps.setString(5, bean.getGender());
			ps.setString(6, bean.getMobileNo());
			ps.setString(7, bean.getEmail());
			ps.setLong(8, bean.getCollegeId());
			ps.setString(9, bean.getCollegeName());
			ps.setString(10, bean.getCreatedBy());
			ps.setString(11, bean.getModifiedBy());
			ps.setTimestamp(12, bean.getCreatedDatetime());
			ps.setTimestamp(13, bean.getModifiedDatetime());

		}
		return bean;
	}

	public StudentBean findByRole(String FirstName) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ST_STUDENT WHERE FIRST_NAME=?");
		ps.setString(1,FirstName);
		ResultSet rs = ps.executeQuery();
		StudentBean bean = null;
		while (rs.next()) {
			bean = new StudentBean();
			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setGender(rs.getString(5));
			bean.setMobileNo(rs.getString(6));
			bean.setEmail(rs.getString(7));
			bean.setCollegeId(rs.getLong(8));
			bean.setCollegeName(rs.getString(9));
			bean.setCreatedBy(rs.getString(10));
			bean.setModifiedBy(rs.getString(11));
			bean.setCreatedDatetime(rs.getTimestamp(12));
			bean.setModifiedDatetime(rs.getTimestamp(13));

		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}
	public List search(StudentBean bean, int pageNo, int pageSize) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_STUDENT WHERE 1=1");
		if (bean != null) {
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append("and findName" + bean.getFirstName() + "%");

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
			bean = new StudentBean();
			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setGender(rs.getString(5));
			bean.setMobileNo(rs.getString(6));
			bean.setEmail(rs.getString(7));
			bean.setCollegeId(rs.getLong(8));
			bean.setCollegeName(rs.getString(9));
			bean.setCreatedBy(rs.getString(10));
			bean.setModifiedBy(rs.getString(11));
			bean.setCreatedDatetime(rs.getTimestamp(12));
			bean.setModifiedDatetime(rs.getTimestamp(13));
			list.add(bean);
		}
		JDBCDataSource.closeConnection(conn);
		return list;

	}

	public StudentBean findByPk(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ST_STUDENT WHERE ID=?");
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();

	StudentBean bean = null;
		while (rs.next()) {
			bean = new StudentBean();
			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setGender(rs.getString(5));
			bean.setMobileNo(rs.getString(6));
			bean.setEmail(rs.getString(7));
			bean.setCollegeId(rs.getLong(8));
			bean.setCollegeName(rs.getString(9));
			bean.setCreatedBy(rs.getString(7));
			bean.setModifiedBy(rs.getString(8));
			bean.setCreatedDatetime(rs.getTimestamp(9));
			bean.setModifiedDatetime(rs.getTimestamp(10));

		}
		JDBCDataSource.closeConnection(conn);

		return bean;

	}
}
