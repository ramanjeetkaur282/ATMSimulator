package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener{
    
   
    JTextField sinTextField, idTextField;
    JRadioButton syes,sno,eyes,eno;
    JButton next;
    JComboBox religion_d,category_d, income_d, edu_d, occ_d;
    String formNo;
    
   //Constructor
    Signup2(String formNo){
       
        this.formNo=formNo;
        setLayout(null);
        setTitle("NEW APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails=new JLabel("Page 2: Additinal Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel religion=new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);
        
        String valReligion[]={"Select an option","Christian","Hindu","Sikh","Muslim", "Others"};
        
        religion_d=new JComboBox(valReligion);
        religion_d.setFont(new Font("Raleway",Font.BOLD,14));
        religion_d.setBounds(300,140,400,30);
        add(religion_d);
        
        

        
        JLabel category=new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100, 190, 200, 30);
        add(category);
        
        String valCategory[]={"Employed","Unemployed","Student","Retired", "Others"};
        category_d=new JComboBox(valCategory);
        category_d.setFont(new Font("Raleway",Font.BOLD,14));
        category_d.setBounds(300,190,400,30);
        add(category_d);
        
        JLabel income=new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100, 240, 200, 30);
        add(income);
        
        String valIncome[]={"Null","<$55,000","<$90,000","<$120,000", "Upto $180,000"};
        income_d=new JComboBox(valIncome);
        income_d.setFont(new Font("Raleway",Font.BOLD,14));
        income_d.setBounds(300,240,400,30);
        add(income_d);
        
        
        JLabel education=new JLabel("Education:");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100, 290, 200, 30);
        add(education);
         
        JLabel qual=new JLabel("Qualification:");
        qual.setFont(new Font("Raleway",Font.BOLD,20));
        qual.setBounds(100, 315, 200, 30);
        add(qual);
        
        String valEdu[]={"High School","Undergraduate","Post-Graduate","Doctorate", "Others"};
        edu_d=new JComboBox(valEdu);
        edu_d.setFont(new Font("Raleway",Font.BOLD,14));
        edu_d.setBounds(300 ,315,400,30);
        add(edu_d);
        
        JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100, 390, 170, 30);
        add(occupation);
        
        String valOcc[]={"Self-Employed","Business","Retired","Student", "Others"};
        occ_d=new JComboBox(valOcc);
        occ_d.setFont(new Font("Raleway",Font.BOLD,14));
        occ_d.setBounds(300 ,390,400,30);
        add(occ_d);
        
        
        JLabel sinNo=new JLabel("SIN Number:");
        sinNo.setFont(new Font("Raleway",Font.BOLD,20));
        sinNo.setBounds(100, 440, 200, 30);
        add(sinNo);
        
        sinTextField=new JTextField();
        sinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        sinTextField.setBounds(300,440,400,30);
        add(sinTextField);
        
        JLabel identity=new JLabel("Identification No:");
        identity.setFont(new Font("Raleway",Font.BOLD,20));
        identity.setBounds(100, 490, 200, 30);
        add(identity);
        
        idTextField=new JTextField();
        idTextField.setFont(new Font("Raleway",Font.BOLD,14));
        idTextField.setBounds(300,490,400,30);
        add(idTextField);
        
        JLabel seniorC=new JLabel("Senior Citizen:");
        seniorC.setFont(new Font("Raleway",Font.BOLD,20));
        seniorC.setBounds(100, 540, 200, 30);
        add(seniorC);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300, 540, 100,30);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(450, 540, 100,30);
        add(sno);
        
        ButtonGroup seniorCiti=new ButtonGroup();
        seniorCiti.add(syes);
        seniorCiti.add(sno);
       
        
        JLabel existAcc=new JLabel("Existing Account:");
        existAcc.setFont(new Font("Raleway",Font.BOLD,20));
        existAcc.setBounds(100, 590, 200, 30);
        add(existAcc);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100,30);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(450, 590, 100,30);
        add(eno);
        
        ButtonGroup existAccount=new ButtonGroup();
        existAccount.add(eyes);
        existAccount.add(eno);
       
        
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
          
         
         String religion=(String)religion_d.getSelectedItem();//returns an Object so typecast it to String
         String category=(String)category_d.getSelectedItem();
         String income=(String)income_d.getSelectedItem();
         String education=(String)edu_d.getSelectedItem();
         String occupation=(String)occ_d.getSelectedItem();
         String seniorCitizen=null;
         if(syes.isSelected()){
             seniorCitizen= "Yes";  
         } else if (sno.isSelected()){
            seniorCitizen = "No";
         }
         
         String sinNumber=sinTextField.getText();
         String existingAccount=null;
         if (eyes.isSelected()){
              existingAccount = "Yes";
         } 
         else if(eno.isSelected())
         {
          existingAccount= "No";
         }      
         
         String id=idTextField.getText();
         
         
         
         try {
           
               Conn c=new Conn();
               String query="insert into signup2 values ('"+formNo+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+id+"','"+sinNumber+"','"+seniorCitizen+"','"+existingAccount+"')";
               c.s.executeUpdate(query);
               setVisible(false);
               new Signup3(formNo);
         
         }
         catch(Exception e){
             System.out.println(e);
         }        
     }
    
    
    public static void main(String args[]){
        new Signup2("");
    }
}
