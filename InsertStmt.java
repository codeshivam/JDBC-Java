import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class InsertStmt {
	public static void main(String[] args)throws SQLException {
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		
		String url="jdbc:mysql://localhost:3306/datademo";
		String user="student";
		String password="student";
		
		try {
			myConn=DriverManager.getConnection(url,user,password);
			myStmt = myConn.createStatement();
			String sql="select * from student";
			myRs=myStmt.executeQuery(sql);
			
			while (myRs.next()) {
				System.out.println(myRs.getString("idstudent")+", "+myRs.getString("name")+", "+myRs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(myConn!=null){
				myConn.close();
			}
			if(myStmt!=null){
				myStmt.close();
			}if(myRs!=null){
				myRs.close();
			}
		}
	}

}
