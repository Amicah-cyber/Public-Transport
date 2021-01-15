/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publictransport1.PaymentSec;

import java.awt.Component;
import javax.swing.JOptionPane;




/**
 *
 * @author Amix
 */
public class Paymentm	
{  
    
    public Paymentm()
    {
    }
          
public void PaymentMade(String s)   
 {   
        Component cmpnt=null;
     JOptionPane.showMessageDialog(cmpnt, s);
}   
public void UndoPaymentMade(String s)   
 {      
    System.out.println(s);
}   
}
// PaymentMethod.java

//DebitCardPayment.java 
//This class represents an algorithm/behavior. 

  
//CashPayment.java 
//This class represents an algorithm/behavior. 

//MobileMoneyPayment.java 
//This class represents an algorithm/behavior. 

