
package bank.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Withdrawal extends JFrame implements ActionListener{
    
      JTextField amount;
      JButton  withdraw, back;
      String pinnumber;
    
    Withdrawal(String pinnumber){
        
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        JLabel text=new JLabel("Enter the amount you want to Withdraw: ");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(150,100,400,20);
        add(text);
        
       amount=new JTextField();
       amount.setFont(new Font("Raleway",Font.BOLD,22));
       amount.setBounds(150,140,350,30);
       add(amount);
       
       withdraw=new JButton("WITHDRAW");
       withdraw.setBackground(Color.BLACK);
       withdraw.setForeground(Color.WHITE);
       withdraw.setOpaque(true);
       withdraw.setBorderPainted(false);
       withdraw.setFocusPainted(false);
       withdraw.setBounds(350,240,150,30);
       withdraw.addActionListener(this);
       add(withdraw);
       
       back=new JButton("BACK");
       
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setOpaque(true);
       back.setBorderPainted(false);
       back.setFocusPainted(false);
       back.setBounds(350,280,150,30);
       back.addActionListener(this);
       add(back);
       
        
        getContentPane().setBackground(Color.WHITE);
        setSize(600,500);
        setLocation(400,80);
        setVisible(true);
    
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==withdraw){
            String withdrawAmount=amount.getText();
            Date date=new Date();
            
            
            if(withdrawAmount.equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter the amount you want to Withdraw.");
            }
            else{
            try{
            Conn c=new Conn();
            String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+withdrawAmount+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"$"+withdrawAmount+" Withdraw Successfully!!");
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
        
        new Withdrawal("");
    }
}
