/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publictransport1;

import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import publictransport1.Objects.Trip;
import publictransport1.Objects.User;
import publictransport1.PaymentSec.MobileMoneyPayment;
import publictransport1.PaymentSec.Paymentm;
import publictransport1.PaymentSec.paymentMaker;
import utils.DBConnect;

/**
 * FXML Controller class
 *
 * @author Amix
 */
public class NavigationbarController implements Initializable {

    @FXML
    private Button passbtn;
    @FXML
    private Button tickbtn;
    @FXML
    private Button contactbtn;
    @FXML
    private Button helpbtn;
    @FXML
    private AnchorPane ap;
    @FXML
    private VBox vb;
    @FXML
    private BorderPane bp;
     Connection conn;
   String s = " The cost is: ";
   boolean n;
   Trip trip;
   private User user = SessionManager.INSTANCE.getUser();
   
    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void booking(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Booking.fxml"));
     try{  
     Parent root = loader.load();           
     BookingController myController = loader.getController();
       bp.setCenter(root);
             myController.fillcombo(); 
             myController.fillspinner();
             myController.dp_ComboActionPerformed();
             myController.setDataagain();
             //myController.receiveData(event);
               
        }catch (IOException ex) {
          // JOptionPane.showMessageDialog(null, ex);
           //System.out.println(ex);
        }
    }

    @FXML
    private void tickets(ActionEvent event) {
          try{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("TicketView.fxml"));
                Parent a = loader.load();
                bp.setCenter(a);
             
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }  
    }

    @FXML
    private void contact(ActionEvent event) {
        try{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Contact.fxml"));
                Parent a = loader.load();
                bp.setCenter(a);
             
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }  
    }

    @FXML
    private void help(ActionEvent event) {
           try{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("help.fxml"));
                Parent a = loader.load();
                bp.setCenter(a);
             
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }  
    }

}
