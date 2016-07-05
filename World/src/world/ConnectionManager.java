package world;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager 
{
	    	public static Connection connectivity() throws ClassNotFoundException, SQLException
	    	{
	    		Connection conn = null;
	    		try{
	    			FileInputStream fis=new FileInputStream("./resources/propertyFile.prop");
	    			Properties prop=new Properties();
	    			prop.load(fis);
	    			
	    		           String driver=prop.getProperty("driver");
	    				   String url=prop.getProperty("url");
	    				   String userName=prop.getProperty("userName");
	    				   String password=prop.getProperty("password");
	    			
			      Class.forName(driver);
			        System.out.println("Driver Loaded");
			        
			    //    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "sa", "sa123");
			        conn = DriverManager.getConnection(url,userName,password);
			        // add application code here
			        System.out.println("Connection Established");
	          
	    		}
	    		catch(ClassNotFoundException e)
	    		{}
	    		
	    		catch(SQLException e)
	    		{} catch (FileNotFoundException e) 
	    		{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		 return conn;	
	    	}

}


