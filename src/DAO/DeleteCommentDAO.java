package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteCommentDAO {
	public void XoaComment(int ID) throws SQLException {
		String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=GuestBook;user=user;password=123";
		Connection conn=null;
		PreparedStatement cstmt=null;
		
		try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 conn=DriverManager.getConnection(dbURL);
	        }catch(SQLException e) {
	        	System.out.println("Database Connect Failed.");
	            return;
	        } catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String sql= "{call dbo.spDeleteComment(?)}";
			cstmt=conn.prepareStatement(sql);
	
			cstmt.setInt(1,ID);
			
			
			
			int temp = cstmt.executeUpdate();
			
			cstmt.close();
			conn.close();
	}
}