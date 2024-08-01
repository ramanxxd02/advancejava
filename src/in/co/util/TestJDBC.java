
	package in.co.util;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	public class TestJDBC {
		

			   public static void main(String[] args) throws Exception {
				  
				   for (int i = 0; i <=100 ; i++) {
					
					   System.out.println("connection =" + i);
					   
					   testGet();
				}
			}

			private static void testGet() throws Exception {
				Connection conn = JDBCDataSource.getConnection();
				
				PreparedStatement pstmt = conn.prepareStatement("select*from newstudent where id=444");
				
				ResultSet rs =pstmt.executeQuery();
				
				while(rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println("\t" + rs.getString(2));
					System.out.println("\t" + rs.getString(3));
					System.out.println("\t" + rs.getString(4));
					System.out.println("\t" + rs.getString(5));
					System.out.println("\t" + rs.getDate(6));
					System.out.println("\t" + rs.getString(7));
				}
				//conn.close
			}
			}


