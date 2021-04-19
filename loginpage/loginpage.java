import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
	public class loginpage implements ActionListener {
		static Connection c=null;
		static Statement stmt=null;
		static Scanner input = new Scanner(System.in);
		public void actionPerformed(ActionEvent event1) {
		
			}
		public boolean judge(information user) {
			// TODO Auto-generated method stub
			try {
				Class.forName("org.postgresql.Driver");
				c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/usersdb","postgres","123456");
				
			}catch(Exception e) {
				e.printStackTrace();
				System.err.println(e.getClass().getName()+": "+e.getMessage());
				System.exit(0);
			}
			/*try {
				stmt=c.createStatement();
				String sql= "CREATE TABLE CUSTOMER "+
				"(USERNAME TEXT NOT NULL,"+
				  "PASSWORD TEXT NOT NULL,"	+
				"FIRST TEXT NOT NULL,"+
				  "LAST TEXT NOT NULL,"+
				"EMAIL TEXT NOT NULL,"+
				  "ADDRESS CHAR(50))";
				stmt.executeUpdate(sql);
				stmt.close();
				c.close();
				
			}catch(Exception e) {
				e.printStackTrace();
				System.err.println(e.getClass().getName()+": "+e.getMessage());
				System.exit(0);
			}*/
		    try {
		    String sql = "select username,password from CUSTOMER where username=? and password=?";
		    PreparedStatement stmt = c.prepareStatement(sql);
		    int statue=0;
		    stmt.setString(1, user.getID());
		    stmt.setString(2, user.getPassword());
		    ResultSet rs = stmt.executeQuery();
		    if (rs.next()) {
		        
		        statue=1;
		    }
		    if(statue==1) {
		    	System.out.println("welcome£¡");
		    	return true;
		    }
		    else 
		    	System.out.println(" wrong username or password");
		    
		    	return false;
		    
		        
					
		    
		    }catch(Exception e){
				e.printStackTrace();
				System.err.println(e.getClass().getName()+": "+e.getMessage());
				System.exit(0);
			}
			return false;
			 


			
		}


	}
