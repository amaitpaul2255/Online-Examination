import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class loginteacher 
{
	Connection conn;
	Statement stmt ;
	public loginteacher(String a,String b,Object c)
	{
		String id=a;
		String pass=b;
		Object ref=c;
		try
    	{
    		conn = DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
    		System.out.println("connected"+conn);
    	}
    	catch(SQLException e4)
    	{
    		e4.printStackTrace();
    	}
        
        try
        {
        	stmt = conn.createStatement();
        	
        }
        catch(SQLException e3)
        {
        	e3.printStackTrace();
        }
		
	}

}
