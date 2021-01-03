import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class DeleteStmt {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/datademo";
		String user = "student";
		String password = "student";
	
		Connection myConn = null;
		Statement myStmt = null;
		
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection(url, user, password);

			// 2. Create a statement
			myStmt = myConn.createStatement();
		
			// 3. Execute SQL query
			String sql = "delete from student where idstudent='2'";
		
			int rowsAffected = myStmt.executeUpdate(sql);

			System.out.println("Rows affected: " + rowsAffected);
			System.out.println("Delete complete.");
			
			String sql1="select * from student";
			ResultSet myRs=myStmt.executeQuery(sql1);
			
			while(myRs.next()){
				System.out.println(myRs.getString("idstudent"));
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}	
		
	}

}
