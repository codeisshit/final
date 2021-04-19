

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * 管理员注册界面
 * 
 */
public class createpage extends JFrame{
	 createpage () {
		register();
	}
	void register() {
		   JFrame frame = new JFrame("create your account");
           frame.setLayout(null);
            JLabel username = new JLabel("username:");
            username.setBounds(250, 150, 100, 25);
            frame.add(username);
        
           

            JLabel passwordStr = new JLabel("password:");
            passwordStr.setBounds(250, 200, 100, 25);
            frame.add(passwordStr);  
            
            JLabel firstname = new JLabel("firstname:");
            firstname.setBounds(250, 250, 100, 25);
            frame.add(firstname);   
           
            JLabel lastname = new JLabel("lastname:");
            lastname .setBounds(250, 300, 100, 30);
            frame.add(lastname );
            
            JLabel email = new JLabel("email:");
            email .setBounds(250, 350, 100, 30);
            frame.add(email);
            
            JLabel address = new JLabel("address:");
            address .setBounds(250, 400, 100, 30);
            frame.add(address );
            
            JTextField userName = new JTextField();
            userName.setBounds(320, 150, 150, 25);
            frame.add(userName);

            JPasswordField Password = new JPasswordField();
            Password.setBounds(320, 200, 150, 25);
            frame.add(Password);

            JTextField firstName = new  JTextField ();
            firstName.setBounds(320, 250, 150, 25);
            frame.add(firstName);

            JTextField lastName = new  JTextField ();
            lastName.setBounds(320, 300, 150, 25);
            frame.add(lastName);
            
            JTextField Email = new  JTextField ();
            Email.setBounds(320, 350, 150, 25);
            frame.add(Email);
            
            
            JTextField Address = new  JTextField ();
            Address.setBounds(320, 400, 150, 25);
            frame.add(Address);
            
            JButton buttonregister = new JButton("register");
            buttonregister.setBounds(350, 450, 70, 25);
            frame.add(buttonregister);
            


            frame.setBounds(400, 100, 800, 640);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
         
            buttonregister.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = userName.getText();
                    String first = firstName.getText();
                    String passwd = new String (Password.getPassword());
                    String last = lastName.getText();
                    String email = Email.getText();
                    String address = Address.getText();
                    //Register
                    create register = new create();
                    register.setfirstname(first);
                    register.setName(name);
                    register.setPassword(passwd);
                    register.setlastname(last);
                    register.setmail(email);
                    register.setaddress(address);
                    //
                    try {
						if(register.JudgeRegister()) {

						    frame.setVisible(false);
						    
						    page.mainpage();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

                }
                
            });
	}}
