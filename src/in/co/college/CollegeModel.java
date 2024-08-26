package in.co.college;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import in.co.JDBCDataSource.JDBCDataSource;

public class CollegeModel {
	ResourceBundle rb=ResourceBundle.getBundle("in.co.bundle.System");
	
	public List search(CollegeBean bean) throws Exception {
		Connection conn=JDBCDataSource.getConnection();
		 StringBuffer sb = new StringBuffer("select * from collegedata where 1=1");
	     if (bean != null) {
				if (bean.getName() != null && bean.getName().length() > 0) {
					sb.append(" and name like '" + bean.getName()+ "%'" );
				}
			}
	        System.out.println("sb query=====>" + sb.toString());
			PreparedStatement ps = conn.prepareStatement(sb.toString());
			ResultSet rs = ps.executeQuery();
			List list = new ArrayList();
			while(rs.next()) {
				 
				 bean.setId(rs.getInt(1));
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
			return list;
	}
	
	public int nextpk() throws Exception {
		int pk=0;
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select max(id) from collegedata");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			pk=rs.getInt(1);
			System.out.println("maxid"+pk);
		}
		return pk+1;
		
		
	}
	public void add(CollegeBean bean) throws Exception{
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("insert into collegedata values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");		
		ps.setLong(1, nextpk());
		ps.setString(2,bean.getName());
		ps.setString(3, bean.getAddress());
		ps.setString(4, bean.getState());
		ps.setString(5, bean.getCity());
		ps.setString(6, bean.getPhoneNo());
		ps.setString(7, bean.getCreatedBy());
		ps.setString(8,bean.getModifiedBy());
		ps.setTimestamp(9, bean.getCreatedDatetime());
		ps.setTimestamp(10, bean.getModifiedDatetime());
		int s = ps.executeUpdate();
		System.out.println("Done"+s);
	}
	public void update(CollegeBean bean) throws Exception {
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("update collegedata set name=?, address=?, state=?, city=?, phone_No=?, created_By=?, modified_By=?, created_Datetime=?, modified_Datetime=? where id=?");		
	
		ps.setString(1,bean.getName());
		ps.setString(2, bean.getAddress());
		ps.setString(3, bean.getState());
		ps.setString(4, bean.getCity());
		ps.setString(5, bean.getPhoneNo());
		ps.setString(6, bean.getCreatedBy());
		ps.setString(7,bean.getModifiedBy());
		ps.setTimestamp(8, bean.getCreatedDatetime());
		ps.setTimestamp(9, bean.getModifiedDatetime());
		ps.setLong(10, bean.getId());
		int s = ps.executeUpdate();
		System.out.println("Done"+s);
	}
	public void delete(CollegeBean bean) throws Exception {
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("delete from collegedata where id =?");
		ps.setLong(1,bean.getId());
		int i=ps.executeUpdate();
		System.out.println("Done"+i);
	}
	public CollegeBean getid(long id) throws Exception {
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("Select* from collegedata where id =?");
		ps.setLong(1,id);
		
		ResultSet rs=ps.executeQuery();
		System.out.println("Done"+rs);
		CollegeBean bean =null;
		while(rs.next()){
			bean=new CollegeBean();
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
		return bean;
	}

}
