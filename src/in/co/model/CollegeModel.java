package in.co.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.bean.Collegebean;
import in.co.bean.RoleBean;
import in.co.college.CollegeBean;
import in.co.exception.DuplicateRecordException;
import in.co.util.JDBCDataSource;

public class CollegeModel {
	public int nextpk() throws Exception {
		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement psmt = conn.prepareStatement("SELECT MAX (ID) FROM ST_COLLEGE ");
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
			System.out.println("max id" + pk);

		}
		JDBCDataSource.closeConnection(conn);
		return pk + 1;
	}

	public void add(CollegeBean bean) throws Exception {
		Collegebean existbean = findByRole(bean.getName());
		if (existbean != null) {
			throw new DuplicateRecordException("Rolename is already exist");
		}
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("INSERT INTO ST_COLLEGE VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setLong(1, bean.getId());
		//ps.setLong(1, nextpk());
		ps.setString(2, bean.getName());
		ps.setString(3, bean.getAddress());
		ps.setString(4, bean.getState());
		ps.setString(5, bean.getCity());
		ps.setString(6, bean.getPhoneNo());
		ps.setString(7, bean.getCreatedBy());
		ps.setString(8, bean.getModifiedBy());
		ps.setTimestamp(9, bean.getCreatedDatetime());
		ps.setTimestamp(10, bean.getModifiedDatetime());
		
		int i = ps.executeUpdate();
		System.out.println("Done");
	}
	public void update(CollegeBean bean) throws Exception {
	Collegebean existbean = findByRole(bean.getName());
		if (existbean != null) {
			throw new DuplicateRecordException("Rolename is already exist");
		}
		Connection conn=JDBCDataSource.getConnection();
        PreparedStatement ps=conn.prepareStatement("UPDATE  ST_COLLEGE SET NAME =?, ADDRESS=?, STATE=?, CITY=?, PHONE_NO=?, CREATED_BY=?, MODIFIED_BY =?, CREATED_DATETIME=?, MODIFIED_DATETIME=? WHERE ID=?");
       
		ps.setString(1, bean.getName());
		ps.setString(2, bean.getAddress());
		ps.setString(3, bean.getState());
		ps.setString(4, bean.getCity());
		ps.setString(5, bean.getPhoneNo());
		ps.setString(6, bean.getCreatedBy());
		ps.setString(7, bean.getModifiedBy());
		ps.setTimestamp(8, bean.getCreatedDatetime());
		ps.setTimestamp(9, bean.getModifiedDatetime());
		 ps.setLong(10, bean.getId());
		int i = ps.executeUpdate();
		System.out.println("Done");
        
}
	public void delete(CollegeBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement psmt = conn.prepareStatement(" DELETE FROM ST_COLLEGE WHERE ID=? ");
		psmt.setLong(1, bean.getId());
		int i = psmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);
		System.out.println("done");

	}

	public List search(CollegeBean bean, int pageNo, int pageSize) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_COLLEGE WHERE 1=1");
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
			bean = new CollegeBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setAddress(rs.getString(3));
			bean.setState(rs.getString(4));
			bean.setCity(rs.getString(5));
			bean.setPhoneNo(rs.getString(6));
			bean.setCreatedBy(rs.getString(7));
			bean.setModifiedBy(rs.getString(8));
			bean.setCreatedDatetime(rs.getTimestamp(9));
			bean.setModifiedDatetime(rs.getTimestamp(10));
			list.add(bean);
		}
		JDBCDataSource.closeConnection(conn);
		return list;

	}

	public CollegeBean findByPk(long id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ST_COLLEGE WHERE ID=?");
		pstmt.setLong(1, id);
		ResultSet rs = pstmt.executeQuery();

		CollegeBean bean = null;
		while (rs.next()) {
			bean = new CollegeBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setAddress(rs.getString(3));
			bean.setState(rs.getString(4));
			bean.setCity(rs.getString(5));
			bean.setPhoneNo(rs.getString(6));
			bean.setCreatedBy(rs.getString(7));
			bean.setModifiedBy(rs.getString(8));
			bean.setCreatedDatetime(rs.getTimestamp(9));
			bean.setModifiedDatetime(rs.getTimestamp(10));

		}
		JDBCDataSource.closeConnection(conn);

		return bean;

	}
	public Collegebean findByRole(String Name) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ST_COLLEGE WHERE NAME=?");
		ps.setString(1, Name);
		ResultSet rs = ps.executeQuery();
		Collegebean bean = null;
		while (rs.next()) {
			bean = new Collegebean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setAddress(rs.getString(3));
			bean.setState(rs.getString(4));
			bean.setCity(rs.getString(5));
			bean.setPhoneNo(rs.getString(6));
			bean.setCreatedBy(rs.getString(7));
			bean.setModifiedBy(rs.getString(8));
			bean.setCreatedDatetime(rs.getTimestamp(9));
			bean.setModifiedDatetime(rs.getTimestamp(10));

		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}
}
