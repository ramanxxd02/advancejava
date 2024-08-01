package in.co.jdbcStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Testconnection {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Root");
		Statement stmt=conn.createStatement();
		int i=stmt.executeUpdate("create table workers(id int primary key,Name varchar(50),post varchar(50),salary int )");
		System.out.println("table created");
		System.out.println("done");
	}

}
