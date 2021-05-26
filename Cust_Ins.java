import java.util.Scanner;
import java.sql.*;

public class Cust_Ins {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/shop";
		String user = "root";
		String password = "";

		Connection myConn = null;
		PreparedStatement myStmt = null;
		//PreparedStatement myStmt1 = null;
		//Statement st=null;
		//ResultSet rs=null;

		Scanner scanner = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			
			myConn = DriverManager.getConnection(url, user, password);
						
			//Insert Record using Scanner class and Prepared statement
			String sqlins="INSERT INTO customer "+
			"(custid, custname, location, pincode) "+
					"values (?, ?, ?, ?)";
			
			myStmt=myConn.prepareStatement(sqlins);
			
			scanner = new Scanner(System.in);
			
			System.out.println("Enter the customer ID:");
			int custid=scanner.nextInt();
			
			System.out.println("Enter the customer name:");
			scanner.nextLine();
			String custname=scanner.nextLine();
			
			System.out.println("Enter the location:");
			String location=scanner.nextLine();
			
			System.out.println("Enter the pincode:");
			int pin=scanner.nextInt();
			
			myStmt.setInt(1, custid);
			myStmt.setString(2, custname);
			myStmt.setString(3, location);
			myStmt.setInt(4, pin);
			
			myStmt.executeUpdate();
			
			System.out.println("Data Inserted");		
			
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
