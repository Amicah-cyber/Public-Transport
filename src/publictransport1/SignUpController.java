/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publictransport1;

import static com.sun.glass.ui.Cursor.setVisible;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import utils.DBConnect;
import publictransport1.Publictransport1;

/**
 * FXML Controller class
 *
 * @author Amix
 */
public class SignUpController implements Initializable {
    Stage m= new Stage();
    Connection conn = null;
PreparedStatement pst = null;

        @FXML
        private TextField ftext;
        @FXML
        private TextField utext;
         @FXML
        private TextField ntext;
          @FXML
        private TextField mtext;
           @FXML
        private PasswordField pass;
           @FXML
        private PasswordField cpass;
           @FXML
        private Text textlogin;
public void signup()
{
    conn= DBConnect.connect();
String fullName=ftext.getText();
         String username= utext.getText();
         String id = ntext.getText();
         String mno = mtext.getText();
         String pass1 = pass.getText();
    try
         {
             String i = "INSERT INTO `passdetails`(`Fullnames`, `Usename`, `Nid_Pass`, `Mobile_no`, `Password`) VALUES ('"+fullName+"','"+username+"','"+id+"','"+mno+"','"+pass1+"')";
             PreparedStatement pst = conn.prepareStatement(i);
             pst.execute();
             JOptionPane.showMessageDialog(null, "Data Inserted");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Passenger.fxml"));
                AnchorPane a = loader.load();
        
                Scene scene = new Scene(a);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNIFIED);
                stage.show();
        } catch (Exception ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, ex);
        }
             
         }catch(Exception e)
         {
         JOptionPane.showMessageDialog(null, e);
         }


}

@FXML
public void gotologin()
{
   
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
                AnchorPane b = (AnchorPane) loader.load();
        
                Scene scene = new Scene(b);
                Stage stage = new Stage();
                stage.setScene(scene);
               // stage.setResizable(false);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        
 }
/*try {
            new Publictransport1(s).start(s);
            s.show();
        } catch (Exception ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, ex);
        }*/


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
