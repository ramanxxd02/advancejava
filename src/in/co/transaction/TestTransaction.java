package in.co.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import in.co.util.JDBCDataSource;

public class TestTransaction {
	
	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		try {
			conn=JDBCDataSource.getConnection();
			Statement stmt=conn.createStatement();
			
			// step 1
			conn.setAutoCommit(false);
			int i = stmt.executeUpdate("insert into marksheet values (21,121,'Rudra',54,65,85)");
			i=stmt.executeUpdate("insert into marksheet values (21,121,'Rudra',54,65,85)");
			i=stmt.executeUpdate("insert into marksheet values (21,121,'Rudra',54,65,85)");
			System.out.println("data inserted");
			// step 2
			conn.commit();
		}catch(Exception e){
			// step 3
			conn.rollback();
			System.out.println("data not inserted");
			System.out.println(e.getMessage());
		}
	}

}
