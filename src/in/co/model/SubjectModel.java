package in.co.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.co.bean.Collegebean;
import in.co.bean.SubjectBean;
import in.co.college.CollegeBean;
import in.co.exception.DuplicateRecordException;
import in.co.util.JDBCDataSource;

public class SubjectModel {
	
	public int nextpk() throws Exception {
		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement psmt = conn.prepareStatement("SELECT MAX (ID) FROM ST_SUBJECT ");
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
			System.out.println("max id" + pk);

		}
		JDBCDataSource.closeConnection(conn);
		return pk + 1;
	}

	public void add(SubjectBean bean) throws Exception {
		SubjectBean existbean = findByRole(bean.getName());
		if (existbean != null) {
			throw new DuplicateRecordException("name is already exist");
		}
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("INSERT INTO ST_SUBJECT VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setLong(1, bean.getId());
		//ps.setLong(1, nextpk());
		ps.setString(2, bean.getName());
		ps.setLong(3, bean.getCourse_id());
		ps.setString(4, bean.getCourse_name());
		ps.setString(5, bean.getDescription());
		ps.setString(6, bean.getCreatedBy());
		ps.setString(7, bean.getModifiedBy());
		ps.setTimestamp(8, bean.getCreatedDatetime());
		ps.setTimestamp(9,bean.getModifiedDatetime());
		int i=ps.executeUpdate();
		System.out.println("Done");
	}
	public void update(SubjectBean bean) throws Exception {
		SubjectBean existbean = findByRole(bean.getName());
		if (existbean != null) {
			throw new DuplicateRecordException("name is already exist");
		}
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("UPDATE ST_SUBJECT SET NAME=?,COURSE_ID=?, COURSE_NAME=?, DESCRIPTION=?, CREATED_BY=?, MODIFIED_BY =?, CREATED_DATETIME=?, MODIFIED_DATETIME=? WHERE ID=?");
		ps.setString(1, bean.getName());
		ps.setLong(2, bean.getCourse_id());
		ps.setString(3, bean.getCourse_name());
		ps.setString(4, bean.getDescription());
		ps.setString(5, bean.getCreatedBy());
		ps.setString(6, bean.getModifiedBy());
		ps.setTimestamp(7, bean.getCreatedDatetime());
		ps.setTimestamp(8,bean.getModifiedDatetime());
		ps.setLong(9, bean.getId());
		int i=ps.executeUpdate();
		System.out.println("Done");
				
	}
	public void delete(SubjectBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("DELETE FROM ST_SUBJECT WHERE ID=?  ");
		ps.setLong(1, bean.getId());
		int i = ps.executeUpdate();

		JDBCDataSource.closeConnection(conn);
		System.out.println("done");

	}
	public List search(SubjectBean bean, int pageNo, int pageSize) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_SUBJECT WHERE 1=1");
		if (bean != null) {
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append("and findName" + bean.getName() + "%");

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
			bean = new SubjectBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setCourse_id(rs.getLong(3));
			bean.setCourse_name(rs.getString(4));
			bean.setDescription(rs.getString(5));
			bean.setCreatedBy(rs.getString(6));
			bean.setModifiedBy(rs.getString(7));
			bean.setCreatedDatetime(rs.getTimestamp(8));
			bean.setModifiedDatetime(rs.getTimestamp(9));
			list.add(bean);
		}
		JDBCDataSource.closeConnection(conn);
		return list;

	}

	public SubjectBean findByPk(long id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ST_SUBJECT WHERE ID=?");
		pstmt.setLong(1, id);
		ResultSet rs = pstmt.executeQuery();

		SubjectBean bean = null;
		while (rs.next()) {
			bean = new SubjectBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setCourse_id(rs.getLong(3));
			bean.setCourse_name(rs.getString(4));
			bean.setDescription(rs.getString(5));
			bean.setCreatedBy(rs.getString(6));
			bean.setModifiedBy(rs.getString(7));
			bean.setCreatedDatetime(rs.getTimestamp(8));
			bean.setModifiedDatetime(rs.getTimestamp(9));

		}
		JDBCDataSource.closeConnection(conn);

		return bean;

	}
	public SubjectBean findByRole(String Name) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ST_SUBJECT WHERE NAME=?");
		ps.setString(1, Name);
		ResultSet rs = ps.executeQuery();
		SubjectBean bean = null;
		while (rs.next()) {
			bean = new SubjectBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setCourse_id(rs.getLong(3));
			bean.setCourse_name(rs.getString(4));
			bean.setDescription(rs.getString(5));
			bean.setCreatedBy(rs.getString(6));
			bean.setModifiedBy(rs.getString(7));
			bean.setCreatedDatetime(rs.getTimestamp(8));
			bean.setModifiedDatetime(rs.getTimestamp(9));

		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}

}
