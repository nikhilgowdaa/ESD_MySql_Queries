import java.util.Scanner;
import java.sql.*;

public class Cust_Create {

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
			
			//Table Creation using statement
			String sqlcr="CREATE TABLE customer "+
			"(custid INTEGER not NULL, "+
					"custname VARCHAR(255), "+
			"location VARCHAR(255), "+
					"pincode INTEGER, "+
			"PRIMARY KEY (custid))";
			
			st=myConn.createStatement();
			
			st.executeUpdate(sqlcr);
			
			System.out.println("Table Created");
						
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
