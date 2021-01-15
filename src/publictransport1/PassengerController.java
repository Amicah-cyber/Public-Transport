/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publictransport1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import publictransport1.Objects.User;

/**
 * FXML Controller class
 *
 * @author Amix
 */
public class PassengerController implements Initializable {

    @FXML
    Button ticketbtn = new Button();
    @FXML
    Button Bookingbtn = new Button();
    @FXML
    Button Contactbtn = new Button();
    @FXML
    Button Helpbtn = new Button();
    @FXML
    Label fullnamelbl = new Label();
    @FXML
    Label idlbl = new Label();
   private User user = SessionManager.INSTANCE.getUser();
    
        /**
     * Initializes the controller class.
     * @param event
     * @return 
     */
  
  
/*public void setUser(User user)
{
  this.user=user;  
}*/
public void setdata(){
 
  String name = user.getfullnames();
  int id = user.getNid();
  String ID = String.valueOf(id);
  fullnamelbl.setText(name);
  idlbl.setText(ID);

}
    public void booking(ActionEvent event){
        //new Booking();
         Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
       
     FXMLLoader loader = new FXMLLoader(getClass().getResource("Booking.fxml"));
     try{  
     Parent root = loader.load();           
        BookingController myController = loader.getController();
        Scene scene = new Scene(root);
       stage = new Stage();
        //Stage stage = new Stage();
        stage.setScene(scene);
            // stage.initModality(Modality.APPLICATION_MODAL);
             stage.show();
             myController.fillcombo(); 
             myController.fillspinner();
             myController.dp_ComboActionPerformed();
             myController.setDataagain();
             //myController.receiveData(event);
               
        }catch (Exception ex) {
          // JOptionPane.showMessageDialog(null, ex);
           //System.out.println(ex);
        }
    }
    public void contact(ActionEvent event){
    try{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Contact.fxml"));
                AnchorPane a = (AnchorPane) loader.load();
        
                Scene scene = new Scene(a);
                Stage stage = new Stage();
                stage.setScene(scene);     
             stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }  
    }
    public void tickets(ActionEvent event){
    try{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("ticket.fxml"));
                AnchorPane a = (AnchorPane) loader.load();
        
                Scene scene = new Scene(a);
                Stage stage = new Stage();
                stage.setScene(scene);     
             stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
    }
     public void help(){
    try{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("help.fxml"));
                AnchorPane a = (AnchorPane) loader.load();
        
                Scene scene = new Scene(a);
                Stage stage = new Stage();
                stage.setScene(scene);     
             stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
