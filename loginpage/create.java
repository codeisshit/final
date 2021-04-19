import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class create {
	    static String username;
	    static String password;
	    static String firstname;
	    static String lastname;
	    static String email;
	    static String address;
	void setName(String username) {
        this.username = username;
    }
    void setfirstname(String firstname) {
        this.firstname = firstname;
    }
    void setPassword(String password) {
        this.password = password;
    }
    void setlastname(String lastname) {
        this.lastname = lastname;
    }
    void setmail(String email) {
        this.email = email;
    }
    void setaddress(String address) {
        this.address = address;
    }

	static Connection c=null;
	static Statement stmt=null;
	static Scanner input = new Scanner(System.in);
    boolean JudgeRegister() throws SQLException, ClassNotFoundException {
        
        if(this.username.equals("")) {
            JOptionPane.showMessageDialog(null, "this can not be null", " ", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.password.equals("")) {
            JOptionPane.showMessageDialog(null, "this can not be null£¡", "ÕËºÅÎª¿Õ", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.firstname.equals("")) {
            JOptionPane.showMessageDialog(null, "this can not be null£¡", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(this.lastname.equals("")) {
            JOptionPane.showMessageDialog(null, "this can not be null£¡", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(this.email.equals("")) {
            JOptionPane.showMessageDialog(null, "this can not be null£¡", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(this.address.equals("")) {
            JOptionPane.showMessageDialog(null, "this can not be null£¡", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }        
        create();
        return true;
    }

private static void create() {
	try {
		Class.forName("org.postgresql.Driver");
		c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/usersdb","postgres","123456");
		
	}catch(Exception e) {
		e.printStackTrace();
		System.err.println(e.getClass().getName()+": "+e.getMessage());
		System.exit(0);
	}

	try {
		c.setAutoCommit(false);
		stmt=c.createStatement();
		String sql= "INSERT INTO CUSTOMER("+
		"USERNAME,PASSWORD,FIRST,LAST,EMAIL,ADDRESS) "+
				"VALUES('"+username+"','"+password+"','"+firstname+"','"+lastname+"','"+email+"','"+address+"')";

		stmt.executeLargeUpdate(sql);
		  System.out.println("OK");
	
		stmt.close();
		c.commit();
		c.close();
		
		
	}catch(Exception e){
		e.printStackTrace();
		System.err.println(e.getClass().getName()+": "+e.getMessage());
		System.exit(0);
	}
	}}
	