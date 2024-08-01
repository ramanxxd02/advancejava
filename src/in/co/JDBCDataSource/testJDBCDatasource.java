package in.co.JDBCDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class testJDBCDatasource {
	public static void main(String[] args) throws Exception {

		for (int i = 0; i <= 100; i++) {

			System.out.println("Connection = " + i);

			testGet();

		}

	}

	private static void testGet() throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where id = 1");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("t" + rs.getInt(6));
		}

	}	
}
