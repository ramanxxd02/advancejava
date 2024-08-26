package in.co.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.bean.TimeTableBean;
import in.co.exception.DuplicateRecordException;
import in.co.util.JDBCDataSource;

public class TimeTableModel {
	public int nextpk() throws Exception {
		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement psmt = conn.prepareStatement(" SELECT MAX(ID) FROM ST_TIMETABLE");
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
			System.out.println("max id" + pk);

		}
		JDBCDataSource.closeConnection(conn);
		return pk + 1;
	}
	public void add(TimeTableBean bean) throws Exception {
		TimeTableBean existBean = findByCourseId(bean.getCourse_id());

		if (existBean != null) {
			throw new DuplicateRecordException("timetable........CourseId is already exist");

		}
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("INSERT INTO ST?_TIMETABLE VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		//ps.setLong(1, bean.getId());
		ps.setLong(1, nextpk());
		ps.setString(2, bean.getSemester());
		ps.setString(3, bean.getDescription());
		ps.setDate(4,new java.sql.Date(bean.getExam_date().getTime()));
		ps.setString(5, bean.getExam_time());
		ps.setLong(6, bean.getCourse_id());
		ps.setString(7, bean.getCourse_name());
		ps.setLong(8, bean.getSubject_id());
		ps.setString(9, bean.getSubject_name());
		ps.setString(10, bean.getCreatedBy());
		ps.setString(11,bean.getModifiedBy());
		ps.setTimestamp(12, bean.getCreatedDatetime());
		ps.setTimestamp(13, bean.getModifiedDatetime());
		int i=ps.executeUpdate();
		System.out.println("Done");
		
		JDBCDataSource.closeConnection(conn);
		
	}
	public void update(TimeTableBean bean) throws Exception {
		TimeTableBean existBean = findByCourseId(bean.getCourse_id());

		if (existBean != null) {
			throw new DuplicateRecordException("timetable........CourseId is already exist");

		}


		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement psmt = conn.prepareStatement(
				"UPDATE ST_TIMETABLE SET SEMESTER = ?,DESCRIPTION = ?, EXAM_DATE = ?, EXAM_TIME = ?,  COURSE_ID = ?, COURSE_NAME = ?,SUBJECT_ID= ?, SUBJECT_NAME= ?,  CREATED_BY=?, MODIFIED_BY =?, CREATED_DATETIME=?, MODIFIED_DATETIME=? WHERE ID=? ");

		psmt.setString(1, bean.getSemester());
		psmt.setString(2, bean.getDescription());
		psmt.setDate(3, new java.sql.Date(bean.getExam_date().getTime()));
		psmt.setString(4, bean.getExam_time());
		psmt.setLong(5, bean.getCourse_id());
		psmt.setString(6, bean.getCourse_name());
		psmt.setLong(7, bean.getSubject_id());
		psmt.setString(8, bean.getSubject_name());
		psmt.setString(9, bean.getCreatedBy());
		psmt.setString(10, bean.getModifiedBy());
		psmt.setTimestamp(11, bean.getCreatedDatetime());
		psmt.setTimestamp(12, bean.getModifiedDatetime());
		psmt.setLong(13, bean.getId());

		int i = psmt.executeUpdate();
		JDBCDataSource.closeConnection(conn);
		System.out.println("update data successfully" + i);

	}

	public void delete(TimeTableBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement psmt = conn.prepareStatement("DELETE FROM ST_TIMETABLE WHERE ID = ?");
		psmt.setLong(1, bean.getId());
		int i = psmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("delete successful..." + i);

	}

	public List search(TimeTableBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("SELECT * FROM ST_TIMETABLE WHERE 1=1");

		if (bean != null) {
			if (bean.getSemester() != null && bean.getSemester().length() > 0) {
				sql.append(" and find_name like '" + bean.getSemester() + "%'");
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
			bean = new TimeTableBean();

			bean.setId(rs.getLong(1));
			bean.setSemester(rs.getString(2));
			bean.setDescription(rs.getString(3));
			bean.setExam_date(rs.getDate(4));
			bean.setExam_time(rs.getString(5));
			bean.setCourse_id(rs.getLong(6));
			bean.setCourse_name(rs.getString(7));
			bean.setSubject_id(rs.getLong(8));
			bean.setSubject_name(rs.getString(9));
			bean.setCreatedBy(rs.getString(10));
			bean.setModifiedBy(rs.getString(11));
			bean.setCreatedDatetime(rs.getTimestamp(12));
			bean.setModifiedDatetime(rs.getTimestamp(13));
			list.add(bean);
		}
		JDBCDataSource.closeConnection(conn);

		return list;
	}

	public TimeTableBean findByCourseId(long courseid) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ST_TIMETABLE WHERE COURSE_ID= ?");
		pstmt.setLong(1, courseid);
		ResultSet rs = pstmt.executeQuery();

		TimeTableBean bean = null;
		while (rs.next()) {
			bean = new TimeTableBean();
			bean.setId(rs.getLong(1));
			bean.setSemester(rs.getString(2));
			bean.setDescription(rs.getString(3));
			bean.setExam_date(rs.getDate(4));
			bean.setExam_time(rs.getString(5));
			bean.setCourse_id(rs.getLong(6));
			bean.setCourse_name(rs.getString(7));
			bean.setSubject_id(rs.getLong(8));
			bean.setSubject_name(rs.getString(9));
			bean.setCreatedBy(rs.getString(10));
			bean.setModifiedBy(rs.getString(11));
			bean.setCreatedDatetime(rs.getTimestamp(12));
			bean.setModifiedDatetime(rs.getTimestamp(13));

		}
		JDBCDataSource.closeConnection(conn);

		return bean;

	}
public TimeTableBean findByPk(long id ) throws Exception {
	Connection conn = JDBCDataSource.getConnection();
	PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ST_TIMETABLE WHERE ID = ?");
	pstmt.setLong(1, id);
	ResultSet rs = pstmt.executeQuery();

	TimeTableBean bean = null;
	while (rs.next()) {
		bean = new TimeTableBean();
		bean.setId(rs.getLong(1));
		bean.setSemester(rs.getString(2));
		bean.setDescription(rs.getString(3));
		bean.setExam_date(rs.getDate(4));
		bean.setExam_time(rs.getString(5));
		bean.setCourse_id(rs.getLong(6));
		bean.setCourse_name(rs.getString(7));
		bean.setSubject_id(rs.getLong(8));
		bean.setSubject_name(rs.getString(9));
		bean.setCreatedBy(rs.getString(10));
		bean.setModifiedBy(rs.getString(11));
		bean.setCreatedDatetime(rs.getTimestamp(12));
		bean.setModifiedDatetime(rs.getTimestamp(13));

	}
	JDBCDataSource.closeConnection(conn);

		return bean;
	}


}
