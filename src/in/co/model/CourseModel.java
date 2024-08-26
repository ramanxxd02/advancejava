package in.co.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.bean.Collegebean;
import in.co.bean.CourseBean;
import in.co.college.CollegeBean;
import in.co.exception.DuplicateRecordException;
import in.co.util.JDBCDataSource;

public class CourseModel {
	public int nextpk() throws Exception {
		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement psmt = conn.prepareStatement("SELECT MAX (ID) FROM ST_COURSE ");
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
			System.out.println("max id" + pk);

		}
		JDBCDataSource.closeConnection(conn);
		return pk + 1;
	}
	
	public  void add(CourseBean bean) throws Exception {
		CourseBean existbean = findByRole(bean.getName());
		if (existbean != null) {
			throw new DuplicateRecordException("name is already exist");
		}
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("INSERT INTO ST_COURSE VALUES( ?, ?, ?, ?, ?, ?, ?, ?)");
		//ps.setLong(1, bean.getId());
		ps.setLong(1, nextpk());
		ps.setString(2, bean.getName());
		ps.setString(3, bean.getDuration());
		ps.setString(4, bean.getDescription());
		ps.setString(5, bean.getCreatedBy());
		ps.setString(6, bean.getModifiedBy());
		ps.setTimestamp(7, bean.getCreatedDatetime());
		ps.setTimestamp(8, bean.getModifiedDatetime());
		int i=ps.executeUpdate();
		System.out.println("Done");
	}
    public void update(CourseBean bean) throws Exception {
    	CourseBean existbean = findByRole(bean.getName());
		if (existbean != null) {
			throw new DuplicateRecordException("name is already exist");
		}
    	Connection conn=JDBCDataSource.getConnection();
    	PreparedStatement ps=conn.prepareStatement("UPDATE ST_COURSE SET NAME=?, DURATION=?, DESCRIPTION=?, CREATED_BY=?, MODIFIED_BY=?, CREATED_DATETIME=?, MODIFIED_DATETIME=? WHERE ID=?");
    	ps.setString(1, bean.getName());
    	ps.setString(2, bean.getDuration());
		ps.setString(3, bean.getDescription());
		ps.setString(4, bean.getCreatedBy());
		ps.setString(5, bean.getModifiedBy());
		ps.setTimestamp(6, bean.getCreatedDatetime());
		ps.setTimestamp(7, bean.getModifiedDatetime());
		ps.setLong(8, bean.getId());
		int i=ps.executeUpdate();
		System.out.println("Done");
	}
    public void delete(CourseBean bean) throws Exception {
    	Connection conn=JDBCDataSource.getConnection();
    	PreparedStatement ps=conn.prepareStatement("DELETE FROM ST_COURSE WHERE ID=? ");
    	ps.setLong(1, bean.getId());
    	int i=ps.executeUpdate();
    	System.out.println("Done");
    	
    }
	public List search(CourseBean bean, int pageNo, int pageSize) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer(" SELECT * FROM ST_COURSE WHERE  1=1");
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

		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();

		while (rs.next()) {
			bean = new CourseBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDuration(rs.getString(3));
			bean.setDescription(rs.getString(4));
			bean.setCreatedBy(rs.getString(5));
			bean.setModifiedBy(rs.getString(6));
			bean.setCreatedDatetime(rs.getTimestamp(7));
			bean.setModifiedDatetime(rs.getTimestamp(8));
			list.add(bean);
		}
		JDBCDataSource.closeConnection(conn);
		return list;

	}
	public CourseBean findByRole(String Name) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ST_COURSE WHERE NAME=?");
		ps.setString(1, Name);
		ResultSet rs = ps.executeQuery();
		CourseBean bean = null;
		while (rs.next()) {
			bean = new CourseBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDuration(rs.getString(3));
			bean.setDescription(rs.getString(4));
			bean.setCreatedBy(rs.getString(5));
			bean.setModifiedBy(rs.getString(6));
			bean.setCreatedDatetime(rs.getTimestamp(7));
			bean.setModifiedDatetime(rs.getTimestamp(8));

		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}
	public CourseBean findByPk(long id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ST_COURSE WHERE ID=?");
		pstmt.setLong(1, id);
		ResultSet rs = pstmt.executeQuery();

		CourseBean bean = null;
		while (rs.next()) {
			bean = new CourseBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDuration(rs.getString(3));
			bean.setDescription(rs.getString(4));
			bean.setCreatedBy(rs.getString(5));
			bean.setModifiedBy(rs.getString(6));
			bean.setCreatedDatetime(rs.getTimestamp(7));
			bean.setModifiedDatetime(rs.getTimestamp(8));

		}
		JDBCDataSource.closeConnection(conn);

		return bean;

	}
}
