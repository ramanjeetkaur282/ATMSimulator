
package bank.management.system;

import java.sql.*;


public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        try
        {
            //1. Register Driver
            //Class.forName(com.mysql.cj.jdbc.Driver);
            
            // 2. Connection String
            c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BankManagement","root","sandy123");
            
            //3. Create Statement
            s=c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
