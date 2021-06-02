import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class loginuser 
{
	Connection conn;
	Statement stmt ;
	public loginuser(String a,String b,Object c) throws SQLException
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
        ArrayList<String> data = new ArrayList<String>();
        String query1 = "select * from studentreg";
        ResultSet rs= stmt.executeQuery(query1);
        while (rs.next())
        {
        	
        }
        
		
	}

}
