/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publictransport1.PaymentSec;

/**
 *
 * @author Amix
 */
public class CashPayment implements iPayment 
{
      Paymentm C;
    public CashPayment(Paymentm pay)
{
    this.C = pay;
    }
     public void execute()   
    {        
        C.PaymentMade("Payment made through cash");
}
  
}
