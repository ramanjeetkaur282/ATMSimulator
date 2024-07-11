
package bank.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
      JTextField amount;
      JButton deposit, back;
      String pinnumber;
    
    Deposit(String pinnumber){
        
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        JLabel text=new JLabel("Enter the amount you want to Deposit: ");
        text.setFont(new Font("System",Font.BOLD,18));
        text.setBounds(150,120,400,50);
        add(text);
        
       amount=new JTextField();
       amount.setFont(new Font("Raleway",Font.BOLD,20));
       amount.setBounds(150,190,350,50);
       add(amount);
       
       deposit=new JButton("DEPOSIT");
       deposit.setBackground(Color.BLACK);
       deposit.setForeground(Color.WHITE);
       deposit.setOpaque(true);
       deposit.setBorderPainted(false);
       deposit.setFocusPainted(false);
       deposit.setBounds(350,270,150,40);
       deposit.addActionListener(this);
       add(deposit);
       
       back=new JButton("BACK");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setOpaque(true);
       back.setBorderPainted(false);
       back.setFocusPainted(false);     
       back.setBounds(350,330,150,40);
       back.addActionListener(this);
       add(back);
       
        
        getContentPane().setBackground(Color.WHITE);
        setSize(600,600);
        setLocation(400,80);
        setVisible(true);
    
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==deposit){
            String depositAmount=amount.getText();
            Date date=new Date();
            
            
            if(depositAmount.equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter the amount you want to Deposit.");
            }
            else{
                try{
            Conn c=new Conn();
            String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+depositAmount+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"$ "+depositAmount+" Deposited Successfully!!");
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            }
            catch(Exception e){
                    System.out.println(e);
                    }
            
            }
            
        
        } else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        }
    
    }
    public static void main(String args[]){
        
        new Deposit("");
    }
}
