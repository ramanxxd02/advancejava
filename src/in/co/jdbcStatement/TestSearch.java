package in.co.jdbcStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSearch {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Root");
		Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select*from workers");
        while(rs.next()) {
        	System.out.println(rs.getInt(1));
        	System.out.println(rs.getString(2));
        	System.out.println(rs.getString(3));
        	System.out.println(rs.getInt(4));
        }
		}

}
