import java.sql.*;

public class DemoClass
{
	public static void main(String args[])throws Exception
	{   String url ="jdbc:mysql://localhost:3306/aleins";
	    String uname="root";
	    String pass="1234";
	    String query="insert into student1 values(3,'hemant')";

	    
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection(url,uname,pass);
		Statement st = con.createStatement();
		int count=st.executeUpdate(query);
		System.out.println(count +"row/s affected");
		st.close();
		con.close();
		
		
	}
}
