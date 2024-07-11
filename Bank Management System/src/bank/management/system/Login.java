package bank.management.system;

import javax.swing.*;
import java.awt.*; // to get image class
import java.awt.event.*; // to get Action Listener Interface
import java.sql.*;

/**
 *
 * @author ramanjeetkaur
 */
public class Login extends JFrame implements ActionListener{
    
    
    //Define the buttons globally
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    //Constructor
    Login(){
        
        // Set Title of Frame
        setTitle("AUTOMATED TELLER MACHINE");
        
        // Set Layout to null so you could customize it
        setLayout(null);
        
        // To get logo Image from icons folder
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/Logo1.png"));
        //Scale the image size
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);

        //We cannot simply place image on frame so create a JLabel
        JLabel label=new JLabel(i3);
        // Set location of Logo
        label.setBounds(100,10,120,100);       
        // Place this label on frame
        add(label);
        
        //Add Title
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD,38));
        text.setBounds(230,35,400,40);
        add(text);
        
        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD,25));
        cardno.setBounds(120,150,150,30);
        add(cardno);
        
        // Text Box for Card Number
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD,25));
        pin.setBounds(120,220,250,30);
        add(pin);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300, 220,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        
        //Login Button
        login=new JButton("SIGN IN");
        login.setBounds(300, 280, 100, 40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setOpaque(true);
        login.setBorderPainted(false);
        login.setFocusPainted(false);
        login.addActionListener(this);
        add(login);
        
        
        clear=new JButton("CLEAR");
        clear.setBounds(450, 280, 100, 40);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setOpaque(true);
        clear.setBorderPainted(false);
        clear.setFocusPainted(false);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGN UP");
        signup.setBounds(300, 350, 250, 40);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setOpaque(true);
        signup.setBorderPainted(false);
        signup.setFocusPainted(false);
        signup.addActionListener(this);
        add(signup);
        
        // Change Background Color
        getContentPane().setBackground(Color.WHITE);
        // To create size of frame
        setSize(800, 520);
        // To make frame visible
        setVisible(true);
        setUndecorated(true);
        setLocation(400,200); // To open frame at location other than Origin
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if (ae.getSource() == login)
        {
            Conn c=new Conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query="Select * from login where cardNumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
                 ResultSet rs=c.s.executeQuery(query);
                 if(rs.next())
                 {
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
                 }
                 else{
                     JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                  }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        } 
        else if (ae.getSource() == signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);   
        }       
    }
    
        public static void main(String args[])
        {
            new Login();
        }
}
