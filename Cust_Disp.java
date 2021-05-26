import java.util.Scanner;
import java.sql.*;

public class Cust_Disp {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/shop";
		String user = "root";
		String password = "";

		Connection myConn = null;
		PreparedStatement myStmt = null;
		PreparedStatement myStmt1 = null;
		//Statement st=null;
		ResultSet rs=null;

		Scanner scanner = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			
			myConn = DriverManager.getConnection(url, user, password);
			
			//Display Record
			String sqldis="SELECT * FROM customer";
			
			myStmt1=myConn.prepareStatement(sqldis);
			
			rs=myStmt1.executeQuery();
			while(rs.next())
			{
				System.out.println("Customer ID:"+rs.getInt(1)+", Customer Name:"+rs.getString(2)+
						", Loaction:"+rs.getString(3)+", Pincode:"+rs.getInt(4));
			}
			
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
			rs.close();
		}
	}
}
