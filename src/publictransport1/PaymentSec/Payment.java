package publictransport1.PaymentSec;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amix
 */
public class Payment {

    /**
     *
     * @param args
     * @param P
     */
    public static void main (String [] args)
    {
        Paymentm P = new Paymentm();
        paymentMaker x =  new paymentMaker();
        x.setPayment(new MobileMoneyPayment(P));
        x.buttonpressed();
         x.setPayment(new CashPayment(P));
        x.buttonpressed();
        
    }
}
