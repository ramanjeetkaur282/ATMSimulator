
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
    
    
    String pinnumber;
    JLabel l1,bank;
    JButton b1;
    MiniStatement(String pinnumber){
    
    this.pinnumber=pinnumber;
    getContentPane().setBackground(Color.WHITE);
    setSize(500,600);
    setLocation(400,80);
        
    setTitle("Mini Statement");
    setLayout(null);
    
    l1=new JLabel();
    add(l1);
    
    bank=new JLabel("Bank of Aurora");
    bank.setFont(new Font("System",Font.BOLD,16));
    bank.setBounds(150,40,200,20);
    add(bank);
    
    JLabel card=new JLabel();
    card.setBounds(50,70,300,20);
    add(card);
    
    JLabel bal=new JLabel();
    bal.setBounds(50,400,300,20);
    add(bal);
    
    
    try{
        Conn c=new Conn();
        ResultSet rs=c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
        while(rs.next()){
            card.setText("Card Number:  "+ rs.getString("cardnumber").substring(0,4)+ "XXXXXXXXXX" + rs.getString("cardnumber").substring(12));   
            }
        }
    catch(Exception e)
        {
        System.out.println(e);
        }
    
    try{
        int balance=0;
        Conn c1=new Conn();
        ResultSet rs=c1.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
        while(rs.next()){
            l1.setText(l1.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
            if(rs.getString("type").equals("Deposit")){
                balance += Integer.parseInt(rs.getString("amount"));
            }else{
                balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            
        bal.setText("Your current account Balance is $"+balance);
        }
    catch(Exception e)
        {
        e.printStackTrace();
        }
    
    
    l1.setBounds(50,100,400,300);
    
    setVisible(true);
    b1=new JButton("Exit");
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    b1.setOpaque(true);
    b1.setBorderPainted(false);
    b1.setFocusPainted(false);
    add(b1);
    
    b1.addActionListener(this);
    
    b1.setBounds(200,500,100,25);
    
    }
       
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String args[]){
    new MiniStatement("").setVisible(true);
    }
    
}
