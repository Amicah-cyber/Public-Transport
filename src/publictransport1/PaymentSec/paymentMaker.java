/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publictransport1.PaymentSec;

import static javafx.scene.input.KeyCode.P;

/**
 *
 * @author Amix
 */
public class paymentMaker {
    iPayment payme;
    public paymentMaker()
    {
    }
    public void setPayment(iPayment payme)
    {
    this.payme = payme;
    }
   public void buttonpressed()
   {
   payme.execute();
   }
}

