package world;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager 
{
	    	public static Connection connectivity() throws ClassNotFoundException, SQLException
	    	{
	    		Connection conn = null;
	    		try{
	    		 
			        Class.forName("com.mysql.jdbc.Driver");
			        System.out.println("Driver Loaded");
			        
			        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "sa", "sa123");
			        // add application code here
			        System.out.println("Connection Established");
	          
	    		}
	    		catch(ClassNotFoundException e)
	    		{}
	    		
	    		catch(SQLException e)
	    		{}
	    		 return conn;	
	    	}

}


