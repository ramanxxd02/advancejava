package in.co.jdbcStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {
		public static void main(String[] args) throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Root");
			Statement stmt=conn.createStatement();
			int i=stmt.executeUpdate("update workers set name='Raman'where id=4");
			System.out.println("Done");
		}

	}



