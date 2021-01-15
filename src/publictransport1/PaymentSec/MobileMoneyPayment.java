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
public class MobileMoneyPayment implements iPayment
{    
    Paymentm M;
    public MobileMoneyPayment(Paymentm pay){
    this.M = pay;
    }
   
    public void execute()   
    {        
      M.PaymentMade("You have made your payment through mobile money");
    }
}
