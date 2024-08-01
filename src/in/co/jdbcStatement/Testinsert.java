package in.co.jdbcStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Testinsert {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Root");
		Statement stmt=conn.createStatement();
		int i=stmt.executeUpdate("insert into workers value(05,'Umesh','laber',5000)");
	System.out.println("Done");
	}

}
