package in.co.jdbcStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Testjdbc {
	public static void main(String[] args) throws Exception {
		//step 1 load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step 2 Driver ko address dene ke liye getConnection
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Root");
		
		//create object of statement
		Statement stmt=conn.createStatement();
		System.out.println("connection is successfully");
	}

}
