package in.co.Marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.mysql.cj.util.DnsSrv.SrvRecord;


public class Marksheetmodel {
	ResourceBundle rb=ResourceBundle.getBundle("in.co.bundle.System");
	
	public void add(Marksheetbean bean) throws Exception {
		Class.forName(rb.getString("Driver"));
		Connection conn=DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("password"));
        PreparedStatement ps=conn.prepareStatement("insert into marksheet values (?,?,?,?,?,?)");
        
        ps.setInt(1, bean.getId());
        ps.setInt(2, bean.getRollno());
        ps.setString(3, bean.getName());
        ps.setInt(4, bean.getPhysics());
        ps.setInt(5,bean.getChemistry());
        ps.setInt(6, bean.getMaths());
        
        int i=ps.executeUpdate();
        System.out.println("done"+i);
	}
	public void update(Marksheetbean bean) throws Exception  {
		
		Class.forName(rb.getString("Driver"));
		Connection conn=DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("password"));
        PreparedStatement ps=conn.prepareStatement("update marksheet set rollno=?,name=?,physics=?,chemistry=?,maths=? where id =?");
        
       
        ps.setInt(1, bean.getRollno());
        ps.setString(2, bean.getName());
        ps.setInt(3, bean.getPhysics());
        ps.setInt(4,bean.getChemistry());
        ps.setInt(5, bean.getMaths());
        ps.setInt(6, bean.getId());
        int i=ps.executeUpdate();
        System.out.println("done"+i);
	}
	public void delete(Marksheetbean bean) throws Exception {
		Class.forName(rb.getString("Driver"));
		Connection conn=DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("password"));
        PreparedStatement ps=conn.prepareStatement("delete from marksheet where id =?");
        
        ps.setInt(1, bean.getId());
        int i=ps.executeUpdate();
        		
        System.out.println("done"+i);
	}
	
	public Marksheetbean idget(int id) throws Exception {
		Class.forName(rb.getString("Driver"));
		Connection conn=DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("password"));
        PreparedStatement ps=conn.prepareStatement("select*from marksheet where id=?");
         ps.setInt(1,id);
      
        ResultSet rs=ps.executeQuery();
        System.out.println("done"+rs);
        Marksheetbean bean=null;
        while(rs.next()) {
        	bean=new Marksheetbean();
           bean.setId(rs.getInt(1));
           bean.setRollno(rs.getInt(2));
           bean.setName(rs.getString(3));
           bean.setPhysics(rs.getInt(4));
           bean.setChemistry(rs.getInt(5));
           bean.setMaths(rs.getInt(6));
        }
		return bean;
	}
	public List Search(Marksheetbean bean) throws Exception {
	     Class.forName(rb.getString("Driver"));
	     Connection conn=DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("password"));
	     StringBuffer sb=new StringBuffer("select*from marksheet where 1=1");
	     if (bean != null) {
				if (bean.getName() != null && bean.getName().length() > 0) {
					//sb.append(" and name like '" + bean.getName()+"'");
				}
			}
	        System.out.println("sb query=====>" + sb.toString());
			PreparedStatement pstmt = conn.prepareStatement(sb.toString());
			ResultSet rs = pstmt.executeQuery();
			List list = new ArrayList();
		    while(rs.next()) {
		    	bean=new Marksheetbean();
		    	 bean.setId(rs.getInt(1));
		           bean.setRollno(rs.getInt(2));
		           bean.setName(rs.getString(3));
		           bean.setPhysics(rs.getInt(4));
		           bean.setChemistry(rs.getInt(5));
		           bean.setMaths(rs.getInt(6));
		           list.add(bean);
		    }
			return list;
		    
		
		
		
	}

}
