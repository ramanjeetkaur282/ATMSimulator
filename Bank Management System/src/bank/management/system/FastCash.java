
package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    
    JButton deposit,withdraw,cash, miniStatement,pinChange,balEnquiry,exit;
    String pinnumber;
    FastCash(String pinnumber){
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
       JLabel text=new JLabel("Please Select Your Withdrawal Amount");
       text.setBounds(170,100,420,55); 
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System",Font.BOLD,20));
       add(text);
       
       deposit=new JButton("$100");
       deposit.setBounds(200,200,150,40);
       deposit.addActionListener(this);
       add(deposit);
       
       withdraw=new JButton("$200");
       withdraw.setBounds(400,200,150,40);
       withdraw.addActionListener(this);
       add(withdraw);
       
       cash=new JButton("$400");
       cash.setBounds(200,300,150,40);
       cash.addActionListener(this);
       add(cash);
       
       miniStatement=new JButton("$500");
       miniStatement.setBounds(400,300,150,40);
       miniStatement.addActionListener(this);
       add(miniStatement);
       
       pinChange=new JButton("$1000");
       pinChange.setBounds(200,400,150,40);
       pinChange.addActionListener(this);
       add(pinChange);
       
       balEnquiry=new JButton("$1500");
       balEnquiry.setBounds(400,400,150,40);
       balEnquiry.addActionListener(this);
       add(balEnquiry);
       
       exit=new JButton("BACK");
       exit.setBounds(400,500,150,40);
       exit.addActionListener(this);
       add(exit);
        
        setSize(700,700);
        setLocation(300,80);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
        }
        
        else{
            String amount= ((JButton)ae.getSource()).getText().substring(1);
            Conn c=new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                        
                    } else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource()!=exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                
                Date date=new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"$"+amount+" Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    
    public static void main(String args[]){
        new FastCash("");
    }
}
