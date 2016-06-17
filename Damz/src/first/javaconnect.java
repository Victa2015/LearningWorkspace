package first;

	//connecting to the database.

	import java.sql.Connection;
	import java.sql.DriverManager;
	import javax.swing.JOptionPane;


	public class javaconnect{
	    
	    Connection conn = null;
	    
	    public static Connection ConnectDb(){
	    
	     try
	        {
	             
	        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        Connection conn = DriverManager.getConnection("jdbc:odbc:datasourcename","username","password");
	        return conn;
	    }
	     catch(Exception e){
	         
	         JOptionPane.showMessageDialog(null,e);
	         return null;
	     }
	    }
	    
	}




	// Login form.

	