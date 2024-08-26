package in.co.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.bean.Collegebean;
import in.co.bean.CourseBean;
import in.co.bean.FacultyBean;
import in.co.bean.SubjectBean;
import in.co.college.CollegeBean;
import in.co.exception.DuplicateRecordException;
import in.co.util.JDBCDataSource;

public class FacultyModel {
	public int nextpk() throws Exception {
		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement psmt = conn.prepareStatement("SELECT MAX (ID) FROM ST_FACULTY ");
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
			System.out.println("max id" + pk);

		}
		JDBCDataSource.closeConnection(conn);
		return pk + 1;
	}

	public void add(FacultyBean bean) throws Exception {

		FacultyBean existbean = findByemail(bean.getEmail());
		if (existbean != null) {
			throw new DuplicateRecordException("email is already exist");
		}

		CollegeModel collegeModel = new CollegeModel();
		CollegeBean collegeBean = collegeModel.findByPk(bean.getCollege_id());
		bean.setCollege_name(collegeBean.getName());
//		System.out.println(bean.getCollege_id());
//	    System.out.println(bean.getCollege_name());

		CourseModel courseModel = new CourseModel();
		CourseBean courseBean = courseModel.findByPk(bean.getCourse_id());
		bean.setCourse_name(courseBean.getName());
//		System.out.println(bean.getCourse_id());
//		System.out.println(bean.getCourse_name());

		SubjectModel subjectModel = new SubjectModel();
		SubjectBean subjectBean = subjectModel.findByPk(bean.getSubject_id());
		bean.setSubject_name(subjectBean.getName());
//		System.out.println(bean.getSubject_id());
//		System.out.println(bean.getSubject_name());

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn
				.prepareStatement(" INSERT INTO ST_FACULTY VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
//		ps.setLong(1, bean.getId());
		ps.setLong(1, nextpk());
		ps.setString(2, bean.getFirst_name());
		ps.setString(3, bean.getLast_name());
		ps.setDate(4, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(5, bean.getGender());
		ps.setString(6, bean.getMobile_no());
		ps.setString(7, bean.getEmail());
		ps.setLong(8, bean.getCollege_id());
		ps.setString(9, bean.getCollege_name());
		ps.setLong(10, bean.getCourse_id());
		ps.setString(11, bean.getCourse_name());
		ps.setLong(12, bean.getSubject_id());
		ps.setString(13, bean.getSubject_name());
		ps.setString(14, bean.getCreatedBy());
		ps.setString(15, bean.getModifiedBy());
		ps.setTimestamp(16, bean.getCreatedDatetime());
		ps.setTimestamp(17, bean.getModifiedDatetime());
		int i = ps.executeUpdate();
		System.out.println("Done");
		JDBCDataSource.closeConnection(conn);

	}

	public void update(FacultyBean bean) throws Exception {
		FacultyBean existbean = findByemail(bean.getEmail());
		if (existbean != null) {
			throw new DuplicateRecordException("email is already exist");
		}
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"UPDATE  ST_FACULTY SET FIRST_NAME=?, LAST_NAME=?, DOB=?, GENDER=?, MOBILE_NO=?, EMAIL=?, COLLEGE_ID=?, COLLEGE_NAME=?, COURSE_ID=?, COURSE_NAME=?, SUBJECT_ID=?, SUBJECT_NAME=?,  CREATED_BY=?, MODIFIED_BY=?, CREATED_DATETIME=?, MODIFIED_DATETIME=? WHERE ID=?");
		ps.setString(1, bean.getFirst_name());
		ps.setString(2, bean.getLast_name());
		ps.setDate(3, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(4, bean.getGender());
		ps.setString(5, bean.getMobile_no());
		ps.setString(6, bean.getEmail());
		ps.setLong(7, bean.getCollege_id());
		ps.setString(8, bean.getCollege_name());
		ps.setLong(9, bean.getCourse_id());
		ps.setString(10, bean.getCourse_name());
		ps.setLong(11, bean.getSubject_id());
		ps.setString(12, bean.getSubject_name());
		ps.setString(13, bean.getCreatedBy());
		ps.setString(14, bean.getModifiedBy());
		ps.setTimestamp(15, bean.getCreatedDatetime());
		ps.setTimestamp(16, bean.getModifiedDatetime());
		ps.setLong(17, bean.getId());
		int i = ps.executeUpdate();
		System.out.println("Done");
		JDBCDataSource.closeConnection(conn);
	}

	public void delete(FacultyBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(" DELETE FROM ST_FACULTY WHERE ID=?");
		ps.setLong(1, bean.getId());
		int i = ps.executeUpdate();
		System.out.println("Done");
		JDBCDataSource.closeConnection(conn);
	}

	public List search(FacultyBean bean, int pageNo, int pageSize) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_FACULTY WHERE 1=1");
		if (bean != null) {
			if (bean.getFirst_name() != null && bean.getFirst_name().length() > 0) {
				sql.append("and findName" + bean.getFirst_name() + "%");

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
			bean = new FacultyBean();
			bean.setId(rs.getLong(1));
			bean.setFirst_name(rs.getString(2));
			bean.setLast_name(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setGender(rs.getString(5));
			bean.setMobile_no(rs.getString(6));
			bean.setEmail(rs.getString(7));
			bean.setCollege_id(rs.getLong(8));
			bean.setCollege_name(rs.getString(9));
			bean.setCourse_id(rs.getLong(10));
			bean.setCourse_name(rs.getString(11));
			bean.setSubject_id(rs.getLong(12));
			bean.setSubject_name(rs.getString(13));
			bean.setCreatedBy(rs.getString(14));
			bean.setModifiedBy(rs.getString(15));
			bean.setCreatedDatetime(rs.getTimestamp(16));
			bean.setModifiedDatetime(rs.getTimestamp(17));
			list.add(bean);
		}
		JDBCDataSource.closeConnection(conn);
		return list;

	}

	public FacultyBean findByPk(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ST_FACULTY WHERE ID=?");
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();

		FacultyBean bean = null;
		while (rs.next()) {
			bean = new FacultyBean();
			bean.setId(rs.getLong(1));
			bean.setFirst_name(rs.getString(2));
			bean.setLast_name(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setGender(rs.getString(5));
			bean.setMobile_no(rs.getString(6));
			bean.setEmail(rs.getString(7));
			bean.setCollege_id(rs.getLong(8));
			bean.setCollege_name(rs.getString(9));
			bean.setCourse_id(rs.getLong(10));
			bean.setCourse_name(rs.getString(11));
			bean.setSubject_id(rs.getLong(12));
			bean.setSubject_name(rs.getString(13));
			bean.setCreatedBy(rs.getString(14));
			bean.setModifiedBy(rs.getString(15));
			bean.setCreatedDatetime(rs.getTimestamp(16));
			bean.setModifiedDatetime(rs.getTimestamp(17));

		}
		JDBCDataSource.closeConnection(conn);

		return bean;

	}

	public FacultyBean findByemail(String email) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ST_FACULTY WHERE EMAIL=?");
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery();

		FacultyBean bean = null;
		while (rs.next()) {
			bean = new FacultyBean();
			bean.setId(rs.getLong(1));
			bean.setFirst_name(rs.getString(2));
			bean.setLast_name(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setGender(rs.getString(5));
			bean.setMobile_no(rs.getString(6));
			bean.setEmail(rs.getString(7));
			bean.setCollege_id(rs.getLong(8));
			bean.setCollege_name(rs.getString(9));
			bean.setCourse_id(rs.getLong(10));
			bean.setCourse_name(rs.getString(11));
			bean.setSubject_id(rs.getLong(12));
			bean.setSubject_name(rs.getString(13));
			bean.setCreatedBy(rs.getString(14));
			bean.setModifiedBy(rs.getString(15));
			bean.setCreatedDatetime(rs.getTimestamp(16));
			bean.setModifiedDatetime(rs.getTimestamp(17));

		}
		JDBCDataSource.closeConnection(conn);

		return bean;

	}

}
