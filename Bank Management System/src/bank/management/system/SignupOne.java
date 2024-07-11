package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;//to get calender
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField,addressTextField,emailTextField,fnameTextField, cityTextField,provinceTextField,zipTextField;
    JDateChooser dateChooser;
    JRadioButton male,female,other,married,unmarried;
    JButton next;
    
   
   //Constructor
    SignupOne(){

        setLayout(null);    
        Random ran=new Random(); //from 'util' package
        random=Math.abs((ran.nextLong()% 9000L) + 1000L);
        
        JLabel formNo= new JLabel("APPLICATION FORM NO. "+random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(140,20,600,40);
        add(formNo);
        
        JLabel personalDetails=new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);
        
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
       // dateChooser.setBackground(Color.BLACK);
        add(dateChooser);
        
        
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100, 290, 100, 30);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(300, 290, 80,30);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(450, 290, 120,30);
        add(female);
        
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        JLabel email=new JLabel("Email:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100, 340, 100, 30);
        add(email);
        
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
        JLabel mStatus=new JLabel("Marital Status:");
        mStatus.setFont(new Font("Raleway",Font.BOLD,20));
        mStatus.setBounds(100, 390, 170, 30);
        add(mStatus);
        
        married=new JRadioButton("Married");
        married.setBounds(300, 390, 100,30);
        add(married);
        
        unmarried=new JRadioButton("UnMarried");
        unmarried.setBounds(450, 390, 100,30);
        add(unmarried);
        
        other=new JRadioButton("Other");
        other.setBounds(600, 390, 100,30);
        add(other);
        
        ButtonGroup martialgroup=new ButtonGroup();
        martialgroup.add(married);
        martialgroup.add(unmarried);
        martialgroup.add(other);
        
        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100, 440, 100, 30);
        add(address);
        
        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
        
        JLabel city=new JLabel("City");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100, 490, 100, 30);
        add(city);
        
        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        JLabel province=new JLabel("Province");
        province.setFont(new Font("Raleway",Font.BOLD,20));
        province.setBounds(100, 540, 100, 30);
        add(province);
        
        provinceTextField=new JTextField();
        provinceTextField.setFont(new Font("Raleway",Font.BOLD,14));
        provinceTextField.setBounds(300,540,400,30);
        add(provinceTextField);
        
        JLabel zcode=new JLabel("Zip Code:");
        zcode.setFont(new Font("Raleway",Font.BOLD,20));
        zcode.setBounds(100, 590, 100, 30);
        add(zcode);
        
        zipTextField=new JTextField();
        zipTextField.setFont(new Font("Raleway",Font.BOLD,14));
        zipTextField.setBounds(300,590,400,30);
        add(zipTextField);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setOpaque(true);
        next.setBorderPainted(false);
        next.setFocusPainted(false);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
               
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae){
         String formNo= "" + random; //long value converted into String
         String name=nameTextField.getText();//get value of name field
         String fname=fnameTextField.getText();//get value of father name field
         String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
         String gender=null;
         if(male.isSelected()){
             gender= "Male";  
         } else if (female.isSelected()){
            gender = "Female";
         }
         
         String email=emailTextField.getText();
         String martialStatus=null;
         if (married.isSelected()){
              martialStatus = "Married";
         } 
         else if(unmarried.isSelected())
         {
          martialStatus= "Unmarried";
         }
         else if(other.isSelected()){
           martialStatus= "Other";
         }
         
         String address=addressTextField.getText();
         String city=cityTextField.getText();
         String province=provinceTextField.getText();
         String zip=zipTextField.getText();
         
         
         try {
             if(name.equals("")){
             JOptionPane.showMessageDialog(null, "Name is Required");
             } else {
                 Conn c=new Conn();
                 String query="insert into signup values ('"+formNo+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+martialStatus+"','"+address+"','"+city+"','"+province+"','"+zip+"')";
                 c.s.executeUpdate(query);
                 
                 setVisible(false);
                 new Signup2(formNo).setVisible(true);
             }
         
         }
         catch(Exception e){
             System.out.println(e);
         }
         
         
     }
    
    
    public static void main(String args[]){
        new SignupOne();
    }
}
