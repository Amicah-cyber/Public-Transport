/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publictransport1;

import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import utils.DBConnect;
import publictransport1.Objects.Trip;
import publictransport1.Objects.User;
import publictransport1.PaymentSec.MobileMoneyPayment;
import publictransport1.PaymentSec.Paymentm;
import publictransport1.PaymentSec.paymentMaker;
/**
 * FXML Controller class
 *
 * @author Amix
 */

public class BookingController implements Initializable {
    @FXML
    ComboBox combo1;
    @FXML
    ComboBox combo11;
    @FXML
    ComboBox combo12;
    @FXML
    DatePicker datepicker;
    @FXML
    Spinner spinner1;
    @FXML
    Button bookbtn;
    @FXML
    Label displaylbl;
    @FXML
    Label userlbl;
    @FXML
    Label idlbl;
    
   Connection conn;
   String s = " The cost is: ";
   boolean n;
   Trip trip = Trip.getTrip();
   private User user = SessionManager.INSTANCE.getUser();
   public BookingController() {
        this.trip = Trip.getTrip();
   }
    

public void setDataagain() {
    System.out.println(user.getfullnames());
  String name = user.getfullnames();
  int id = user.getNid();
  String ID = Integer.toString(id);
  userlbl.setText(name);
  idlbl.setText(ID);
}
    @FXML
     public void Dest_comboActionPerformed() {                                           
        // TODO add your handling code here:
    try{
        String a = (String) combo1.getValue();
        String b = (String) combo11.getValue();
        String c = (String) combo12.getValue();
        switch(a+b)
        {
            case ("Mombasa"+ "Nairobi"):
                displaylbl.setText(s+"1800");
                break;
          
            case ("Mombasa"+ "Nyeri"):
                displaylbl.setText(s+"3000");
                break;
            case ("Mombasa"+ "Karatina"):
                displaylbl.setText(s+"2000");
                break;
            case ("Nairobi"+ "Mombasa"):
                displaylbl.setText(s+"1800");
                break;
            case ("Nairobi"+ "Karatina"):
                displaylbl.setText(s+"300");
                break;
            case ("Nairobi"+ "Nyeri"):
                displaylbl.setText(s+"450");
                break;
            case ("Nyeri"+ "Mombasa"):
                displaylbl.setText(s+"3000");
                break;
            case ("Karatina" + "Mombasa"):
                displaylbl.setText(s+"2300");
                break;
            case ("Mombasa"+"Muranga" ):
                displaylbl.setText(s+"1700");
                break;
            case ("Mombasa"+ "Nakuru"):
                displaylbl.setText(s+"1800");
                break;
            case ("Mombasa"+ "Eldoret"):
                displaylbl.setText(s+"3000");
                break;
            case ("Mombasa"+"Naivasha" ):
                displaylbl.setText(s+"1700");
                break;
            case ("Naivasha"+ "Mombasa"):
                displaylbl.setText(s+"2000");
                break;
            case ("Eldoret"+ "Mombasa"):
                displaylbl.setText(s+"3000");
                break;
             case ("Nairobi"+ "Naivasha"):
                displaylbl.setText(s+"350");
                break; 
                
        }
    }catch(Exception e)
    {
      JOptionPane.showMessageDialog(null, e);  
    }
    } 
     
     public void fillcombo(){
    try {  
        conn = DBConnect.connect();
            // Execute query and store result in a resultset
            String sql="SELECT * FROM `tripplaces`";
            PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs=pst.executeQuery();
            while (rs.next()) {
                //get string from db,whichever way 
                combo1.getItems().addAll(rs.getString("towns"));
                combo11.getItems().addAll(rs.getString("towns"));
            }
 

        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        } 
    }

    public void dp_ComboActionPerformed() {                                         
        // TODO add your handling code here:\
        combo12.getItems().addAll("14-Seater","12-Seater");
        
    } 
 
  public void fillspinner(){
  try {
      ObservableList<String> time =FXCollections.observableArrayList("4:00AM","6:00AM","8:00AM","10:00AM","12:00PM","2:00PM","4:00PM","6:00PM","8:00PM");
  SpinnerValueFactory<String> valueFactory= new SpinnerValueFactory.ListSpinnerValueFactory<>(time);
  valueFactory.setValue("4:00AM");
  spinner1.setValueFactory(valueFactory);
  
  }catch(Exception e)
  {
  JOptionPane.showMessageDialog(null, e);
  }
  }
 public void setdata(Trip selectedtrip)
  {
     this.trip = selectedtrip;
       try{
        String a = (String) combo1.getValue().toString();
        String b = (String) combo11.getValue().toString();
        String c = (String) combo12.getValue().toString();
        LocalDate d = datepicker.getValue();
        String e = (String) spinner1.getValue().toString();
        
        selectedtrip.setOrigin(a);
        selectedtrip.setDestination(b);
        selectedtrip.setCoach(c);
        selectedtrip.setDate(d);
        selectedtrip.setTime(e);
        
        System.out.println(a + b + c);
        }catch(Exception ex)
        {
         JOptionPane.showMessageDialog(null, ex);
        }
        
        
  }
 public boolean setPaymentMethod(ActionEvent event)
 {
        Component f=null;
    int a=JOptionPane.showConfirmDialog(f,"Payment via Mobile money");  
if(a==JOptionPane.YES_OPTION){
    Paymentm P = new Paymentm();
        paymentMaker x =  new paymentMaker();
        x.setPayment(new MobileMoneyPayment(P));
    n = true;
}  else {
        n = false;
            try {              
          Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Navigationbar.fxml"));
                Parent root = loader.load();
                NavigationbarController controller1 = loader.getController();
                Scene scene = new Scene(root); 
            stage = new Stage();
            //controller1.setUser(user);
                controller1.booking(event);
                stage.setScene(scene);     
            // stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
    }
    return n;
 }

    /**
     *
     * @param event
     * @param selectedtrip
     */
  
    @FXML
   private void bookatrip(ActionEvent event){
        //new Booking();
       setdata(trip); 
       setPaymentMethod(event);
     if(n==true)
     {
         Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
     
       try{
     FXMLLoader loader = new FXMLLoader(getClass().getResource("ticket.fxml"));
       Parent root = loader.load();           
        TicketController myController = loader.getController();
        Scene scene = new Scene(root);
        //Stage stage = new Stage();
        stage.setScene(scene);
            // stage.initModality(Modality.APPLICATION_MODAL);
             stage.show();
           myController.gettripdata(trip);
           myController.setdata();
           myController.insertdata();
          // myController.getuserdata(s, s, 0);
             
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
     }
    }
 
public void outputPrice()
{
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
            
   
    }
}
