
package bank.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;


public class BalEnquiry extends JFrame implements ActionListener{
    
    String pinnumber;
    
    JButton back;
    BalEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        back=new JButton("BACK");
        back.setBounds(350,400,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setOpaque(true);
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.addActionListener(this);
        add(back);
        
        Conn c=new Conn();
        int balance=0;
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                        
                    } else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
               
            }
            catch(Exception e){
                System.out.println(e);
         }
        
         JLabel l1=new JLabel("Your current Balance is $"+balance);
         l1.setFont(new Font("Raleway",Font.BOLD,25));
         l1.setBounds(100,200,400,30);
         add(l1);
         
        setSize(500,500);
        setLocation(400,80);
        setUndecorated(true);
        setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
        }
    
    }
    public static void main(String args[]){
    new BalEnquiry("");
    }
}
