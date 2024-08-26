package in.co.studentdata;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import in.co.JDBCDataSource.JDBCDataSource;
import in.co.college.CollegeBean;

public class StudentModel {
	ResourceBundle rb=ResourceBundle.getBundle("in.co.bundle.System");
	
	public void add(StudentBean bean) throws Exception {
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("insert into studentdetail values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");		
	     ps.setLong(1, nextpk());
	     ps.setString(2,bean.getFirstname());
	     ps.setString(3,bean.getLastname());
	     ps.setDate(4, new java.sql.Date(bean.getDob().getTime()));
	     ps.setString(5, bean.getGender());
	     ps.setString(6, bean.getMobileNo());
	     ps.setString(7, bean.getEmail());
	     ps.setLong(8, bean.getCollegeid());
	     ps.setString(9, bean.getCollegename());
	     ps.setString(10, bean.getCreatedBy());
	     ps.setString(11, bean.getModifiedBy());
	     ps.setTimestamp(12, bean.getCreatedDatetime());
	     ps.setTimestamp(13, bean.getModifiedDatetime());
	     
	     int i=ps.executeUpdate();
	     System.out.println("Done"+i);
	     
	}
	public void update(StudentBean bean) throws Exception {
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("update studentdetail set firstname=?,lastname=?, dob=?, gender=?, mobile_No=?, email=?, collegeid=?, collegename=?, created_By=?, modified_By=?, created_Datetime=?, modified_Datetime=? where id=?");		
	    
	     ps.setString(1,bean.getFirstname());
	     ps.setString(2,bean.getLastname());
	     ps.setDate(3, new java.sql.Date(bean.getDob().getTime()));
	     ps.setString(4, bean.getGender());
	     ps.setString(5, bean.getMobileNo());
	     ps.setString(6, bean.getEmail());
	     ps.setLong(7, bean.getCollegeid());
	     ps.setString(8, bean.getCollegename());
	     ps.setString(9, bean.getCreatedBy());
	     ps.setString(10, bean.getModifiedBy());
	     ps.setTimestamp(11, bean.getCreatedDatetime());
	     ps.setTimestamp(12, bean.getModifiedDatetime());
	     ps.setLong(13, bean.getId());
	     
	     int i=ps.executeUpdate();
	     System.out.println("Done"+i);
	}
	public void delete(StudentBean bean) throws Exception {
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("delete from studentdetail where id =?");
		ps.setLong(1,bean.getId());
		int i=ps.executeUpdate();
	     System.out.println("Done"+i);
	}
	public int nextpk() throws Exception {
		int pk=0;
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select max(id) from studentdetail");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			pk=rs.getInt(1);
			System.out.println("maxid"+pk);
		}
		return pk+1;
		
		
		
	}
	public StudentBean getid(long id) throws Exception {
	Connection conn=JDBCDataSource.getConnection();
	PreparedStatement ps=conn.prepareStatement("Select* from studentdetail where id =?");
	ps.setLong(1,id);
	
	ResultSet rs=ps.executeQuery();
	System.out.println("Done"+rs);
	StudentBean bean =null;
	while(rs.next()){
	bean=new StudentBean();
	 ps.setLong(1,bean.getId());
     ps.setString(2,bean.getFirstname());
     ps.setString(3,bean.getLastname());
     ps.setDate(4, new java.sql.Date(bean.getDob().getTime()));
     ps.setString(5, bean.getGender());
     ps.setString(6, bean.getMobileNo());
     ps.setString(7, bean.getEmail());
     ps.setLong(8, bean.getCollegeid());
     ps.setString(9, bean.getCollegename());
     ps.setString(10, bean.getCreatedBy());
     ps.setString(11, bean.getModifiedBy());
     ps.setTimestamp(12, bean.getCreatedDatetime());
     ps.setTimestamp(13, bean.getModifiedDatetime());
		
	}
	return bean;
	}
}
