package codeTester;
import java.sql.*;
public class sqlds {
	public static void main(String[] args) {
//		try {
//			Driver d = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
//			System.out.println("Connection works");
//		} catch (Exception e) {
//			System.out.println("Connection failed");
//		}
		Connection conn = null;
		try {
			String userName = "Victor";
			String password = "Note4";
			String url = "jdbc:mysql://localhost/films";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("Database connection successful.");
			Statement stmt;
			ResultSet rs;
			stmt =conn.createStatement();
			rs = stmt.executeQuery("Select * from films");
			while(rs.next()){
				int Name = rs.getInt("Name");
				String date = rs.getString("Date");
				String director = rs.getString("Director");
				System.out.println("Name: "+ Name);
				System.out.println("Director: "+ director);
				System.out.println("Date: "+ date);
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Failed to connect.");
		}
		finally {
			if(conn !=null){
				try{
					conn.close();
					System.out.println("Database connection Closed.");
					
				}catch(SQLException e){
					System.out.println("Database connection cannot be closed. ");
				}
			}
		}
		
	}
	
}
