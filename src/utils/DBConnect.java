/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Amix
 */
public class DBConnect {
    
    public static Connection connect(){
    
    Connection con=null;
    try{
    Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publictransport?","root","");
    //JOptionPane.showMessageDialog(null, "Connection Successful");
    } catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    
    }
    return con;
    }
    
    
}
