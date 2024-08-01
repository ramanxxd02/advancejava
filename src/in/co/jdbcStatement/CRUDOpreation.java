package in.co.jdbcStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDOpreation {
   public static void main(String[] args) throws Exception {
	//add();
	//update();
	//delete();
	// search();
	 //findbysalary();
	  //findbyid();
	   authenticate();
	   
}
// find by id and salary
private static void authenticate() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Root");
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery("select*from workers where id=5 and salary=5000");
	System.out.println("Done");

	
}
// find by id 
private static void findbyid() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Root");
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery("select*from workers where id=5");
	System.out.println("done");
	
}
//  find by salary
private static void findbysalary() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Root");
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery("select*from workers where salary=55000");
	System.out.println("done");
	
}

private static void search() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Root");
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery("select*from workers");
	while (rs.next()) {
		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getString(3));
		System.out.println(rs.getInt(4));
	}
}

private static void delete() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Root");
	Statement stmt=conn.createStatement();
	int i=stmt.executeUpdate("delete from workers where id=6 ");
	System.out.println("Done");
	
}

private static void update() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Root");
	Statement stmt=conn.createStatement();
	int i=stmt.executeUpdate("update workers set name='Raj'where id=6");
	System.out.println("done");
	
}

private static void add() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Root");
	Statement stmt=conn.createStatement();
	int i=stmt.executeUpdate("insert into workers value(07,'rupesh','laber',5000)");
System.out.println("Done");
	
}

}
