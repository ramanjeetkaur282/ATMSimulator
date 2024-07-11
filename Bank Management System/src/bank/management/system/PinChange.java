
package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




public class PinChange extends JFrame implements ActionListener{
    
    
    JPasswordField pin,repin;
    JButton change, back;
    String pinnumber;
    
    PinChange(String pinnumber){
        
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setBounds(150,100,200,30);
        text.setFont(new Font("System",Font.BOLD,16));
        add(text);
        
        JLabel pintext=new JLabel("NEW PIN");
        pintext.setBounds(150,150,150,30);
        pintext.setFont(new Font("System",Font.BOLD,16));
        add(pintext);
        
        pin=new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(150,180,150,30);
        add(pin);
        
        JLabel rpintext=new JLabel("CONFIRM PIN");
        rpintext.setBounds(150,220,150,30);
        rpintext.setFont(new Font("System",Font.BOLD,16));
        add(rpintext);
        
        repin=new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(150,250,150,30);
        add(repin);
        
        change=new JButton("CHANGE");
        change.setBounds(180,300,100,30);
        change.setBackground(Color.BLACK);
        change.setForeground(Color.WHITE);
        change.setOpaque(true);
        change.setBorderPainted(false);
        change.setFocusPainted(false);
        change.addActionListener(this);
        add(change);
        
        back=new JButton("BACK");
        back.setBounds(180,350,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setOpaque(true);
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.addActionListener(this);
        add(back);
        
        
        
        
        setSize(500,500);
        setLocation(300,80);
        setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        
        if(ae.getSource()==change)
            {
            try{
            String npin=pin.getText();
            String rpin=repin.getText();
        
            if(!npin.equals(rpin))
                {
                    JOptionPane.showMessageDialog(null,"Entered pin does not match.");
                    return;
                }
        
            if(npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please enter PIN");
                    return;
                }
        
            if(rpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please Confirm PIN");
                    return;
                }
            
            Conn c = new Conn();
            String query1="update bank set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
            String query2="update login set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
            String query3="update Signup3 set pinNumber = '"+rpin+"' where pinNumber ='"+pinnumber+"'";
            
            c.s.executeUpdate(query1);
             
            c.s.executeUpdate(query2);
             
            c.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "PIN chnaged successfully!!");
            setVisible(false);
            new Transactions(rpin).setVisible(true);
            
            }
        catch(Exception e)
            {
                System.out.println(e);
            }
        
            
            }
        else if(ae.getSource()== back)
            {
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
        
            }
    }
    
    public static void main(String args[]){
     new PinChange("");
    }
    
}
