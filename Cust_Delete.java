import java.util.Scanner;
import java.sql.*;

public class Cust_Delete {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/shop";
		String user = "root";
		String password = "";

		Connection myConn = null;
		PreparedStatement myStmt = null;
		//PreparedStatement myStmt1 = null;
		Statement st=null;
		//ResultSet rs=null;

		Scanner scanner = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			
			myConn = DriverManager.getConnection(url, user, password);
			
			//Delete record with pincode 576104
			String sqldel="DELETE FROM customer WHERE pincode='576104'";
			
			st=myConn.createStatement();
			
			st.executeUpdate(sqldel);
			System.out.println("Deleted Record with pincode 576104");
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close();
			}

			if (scanner != null) {
				scanner.close();
			}
			//rs.close();
		}
	}
}
