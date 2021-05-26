import java.util.Scanner;
import java.sql.*;

public class Call_Statement {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/shop";
		String user = "root";
		String password = "";

		Connection myConn = null;
		PreparedStatement myStmt = null;
		CallableStatement cs = null;
		//PreparedStatement myStmt1 = null;
		//Statement st=null;
		//ResultSet rs=null;

		Scanner scanner = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			scanner=new Scanner(System.in);
			myConn = DriverManager.getConnection(url, user, password);
			
			String sqlcall="{call getcustname ( ?, ?)}";
			cs = myConn.prepareCall(sqlcall);
			
			System.out.println("Enter the Customer ID:");
			int id=scanner.nextInt();
			
			cs.setInt(1, id);
			cs.execute();
			String name=cs.getString(2);
			
			System.out.println("Customer name for customer ID:"+id+" is "+name);
								
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
			cs.close();
		}
	}
}
