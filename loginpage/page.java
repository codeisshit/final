

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class page extends JFrame{    
	
    public static void main(String []args) { 
    	mainpage();
    }
    
    public static void mainpage(){
	JFrame frame = new JFrame("login in");
        frame.setLayout(null);
        
        JLabel nameStr = new JLabel("account:");
        nameStr.setBounds(200, 200, 400, 25);
        frame.add(nameStr);
        
        JLabel passwordStr = new JLabel("password:");
        passwordStr.setBounds(190, 250, 400, 25);
        frame.add(passwordStr);  
        
        JTextField userID = new JTextField();
        userID.setBounds(310, 200, 150, 25);
        frame.add(userID);
        
        JPasswordField password = new JPasswordField();
        password.setBounds(310, 250, 150, 25);
        frame.add(password);
        
        JButton buttonlogin = new JButton("login");
        buttonlogin.setBounds(200, 300, 150, 25);
        frame.add(buttonlogin);
        
        JButton buttonregister = new JButton("create account");
        buttonregister.setBounds(375, 300, 150, 25);
        frame.add(buttonregister);  
        
        frame.setBounds(400, 100, 800, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        //
         buttonlogin.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
                String ID = userID.getText();
                String passwd = new String (password.getPassword());
                  
                //
                information user = new information();
                user.setID(ID);
                user.setPassword(passwd);
                
                //
                loginpage a = new loginpage();
                a.judge(user);
          
                if(a.judge(user)==false) {
                	//
                	JOptionPane.showMessageDialog(null, "wrong username or password", "", JOptionPane.WARNING_MESSAGE);
                	//
                	password.setText("");
                	//
                	userID.setText("");
                	
                	//
                	System.out.println("fail");
                } else {
                	//
                	JOptionPane.showMessageDialog(null, "successful", "", JOptionPane.NO_OPTION);
                	//
                	frame.setVisible(false);
                    
                        
                }
               
            }
        });
         
         //
         buttonregister.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
        		 //create page
                 frame.setVisible(false);
        		createpage a = new createpage(); 
        	 }
         });
	}


}
