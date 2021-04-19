import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;



public class login {

	static Connection c=null;
	static Statement stmt=null;
 static Scanner input = new Scanner(System.in);
 public static void main(String[] args) {
	
		try {
			Class.forName("org.postgresql.Driver");
			c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/usersdb","postgres","123456");
			
			register();
		}catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}}
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
private static void register() {
	System.out.println("1 :login in 2: create account");
		int i=input.nextInt();
		switch(i){
			case 1:
				login();
				break;
			case 2:
				create();
				break;
			default:
				System.out.println("no this option");
				register();
			
			}
		}
private static void create() {
	// TODO Auto-generated method stub
	System.out.println("please enter your Username£º");
	String username=input.next();
	System.out.println("please enter your password");
    String password = input.next();
	System.out.println("please enter your First Name£º");
    String firstname = input.next();
    System.out.println("please enter your Last Name£º");
    String lastname = input.next();
    System.out.println("please enter your email£º");
    String email = input.next();
    System.out.println("please enter your Address£º");
    String Address = input.next();
    

	try {
		c.setAutoCommit(false);
		stmt=c.createStatement();
		String sql= "INSERT INTO CUSTOMER("+
		"USERNAME,PASSWORD,FIRST,LAST,EMAIL,ADDRESS) "+
				"VALUES('"+username+"','"+password+"','"+firstname+"','"+lastname+"','"+email+"','"+Address+"')";

		stmt.executeLargeUpdate(sql);
		  System.out.println("OK");
		  login();
		stmt.close();
		c.commit();
		c.close();
		
		
	}catch(Exception e){
		e.printStackTrace();
		System.err.println(e.getClass().getName()+": "+e.getMessage());
		System.exit(0);
	}
	}
	

private static void login() {
	// TODO Auto-generated method stub
	System.out.println("please enter your Username£º");
	String username=input.next();
	System.out.println("please enter your password");
    String password = input.next();
    try {
    String sql = "select username,password from CUSTOMER where username=? and password=?";
    PreparedStatement stmt = c.prepareStatement(sql);
    stmt.setString(1, username);
    stmt.setString(2, password);
    ResultSet rs = stmt.executeQuery();
    if (rs.next()) {
        System.out.println("welcome£¡");
    } else {
        System.out.println(" wrong username or password, 1 enter again£º2 create a account");
	     register();
		}
    
    }catch(Exception e){
		e.printStackTrace();
		System.err.println(e.getClass().getName()+": "+e.getMessage());
		System.exit(0);
	}
   


	
}
}

