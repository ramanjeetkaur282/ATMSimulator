
package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    
    
    JButton deposit,withdraw,cash, miniStatement,pinChange,balEnquiry,exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        
    
        setLayout(null);
        getContentPane().setBackground(Color.DARK_GRAY);
        
//        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/ATM4.jpeg"));
//        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
//        ImageIcon i3=new ImageIcon(i2);
//        JLabel image=new JLabel(i3);
//        image.setBounds(0,0,900,900);
//        add(image);
//        
       JLabel text=new JLabel("Please Select Your Transaction");
       text.setBounds(240,100,400,55); 
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System",Font.BOLD,22));
       add(text);
       
       deposit=new JButton("Deposit");
       deposit.setBounds(200,220,200,50);
       deposit.setFont(new Font("Raleway",Font.PLAIN,20));
       deposit.addActionListener(this);
       add(deposit);
       
       withdraw=new JButton("Cash Withdrawal");
       withdraw.setBounds(450,220,200,50);
       withdraw.setFont(new Font("Raleway",Font.PLAIN,20));
       withdraw.addActionListener(this);
       add(withdraw);
       
       cash=new JButton("Fast Cash");
       cash.setBounds(200,320,200,50);
       cash.setFont(new Font("Raleway",Font.PLAIN,20));
       cash.addActionListener(this);
       add(cash);
       
       miniStatement=new JButton("Mini Statement");
       miniStatement.setBounds(450,320,200,50);
       miniStatement.setFont(new Font("Raleway",Font.PLAIN,20));
       miniStatement.addActionListener(this);
       add(miniStatement);
       
       pinChange=new JButton("PIN Change");
       pinChange.setBounds(200,420,200,50);
       pinChange.setFont(new Font("Raleway",Font.PLAIN,20));
       pinChange.addActionListener(this);
       add(pinChange);
       
       balEnquiry=new JButton("Balance Enquiry");
       balEnquiry.setBounds(450,420,200,50);
       balEnquiry.setFont(new Font("Raleway",Font.PLAIN,20));
       balEnquiry.addActionListener(this);
       add(balEnquiry);
       
       exit=new JButton("EXIT");
       exit.setBounds(350,520,200,50);
       exit.setFont(new Font("Raleway",Font.PLAIN,20));
       exit.addActionListener(this);
       add(exit);
        
        setSize(800,700);
        setLocation(300,70);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
            System.exit(0);    
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdraw){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }
         else if(ae.getSource()==cash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinChange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balEnquiry){
          setVisible(false);
          new BalEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==miniStatement){
          setVisible(false);
          new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    
    public static void main(String args[]){
        new Transactions("");
    }
}
