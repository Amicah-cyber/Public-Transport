/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publictransport1;

import java.awt.HeadlessException;
import publictransport1.Objects.User;
import java.io.IOException;
import utils.DBConnect;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static publictransport1.Objects.User.user;

/**
 *
 * @author Amix
 */

public class LoginController implements Initializable {
    @FXML
     private TextField text1;
    @FXML
     private PasswordField pass1;
    @FXML
     private Label lblerror;
    @FXML
     private Label lblerr; 
    @FXML
     private Text signuptxt;
    
 Connection conn=DBConnect.connect();
 PreparedStatement pst = null;
 ResultSet rs = null;
 private Statement statement; 
 User user;
 SessionManager sessionManager = SessionManager.INSTANCE;
//sessionManager.setUser(user);
 
public void Login(ActionEvent event){
        String username = text1.getText();
      String pass = pass1.getText();
        String sql1 = "SELECT * FROM `passdetails` WHERE Usename = ? and Password = ?";
        try
        {
         pst = conn.prepareStatement(sql1);
         pst.setString(1,username);
         pst.setString(2,pass);  
         rs=pst.executeQuery();  
         if(rs.next())
         {
             lblerror.setText("LOGIN SUCCESSFUL");
           String fullname = rs.getString("Fullnames");
           int id = rs.getInt("Nid_Pass");
           String mobile = rs.getString("Mobile_no");
             user = User.setUseratt(fullname,mobile,id);  
             sessionManager.setUser(user);
           //user = new User(fullname,mobile,id);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Navigationbar.fxml"));
                Parent a = loader.load();
                NavigationbarController controller1 = loader.getController();
                Scene scene = new Scene(a);
                //controller1.setUser(user);
                controller1.booking(event);
                stage.setScene(scene);     
            // stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
         }else{
            lblerr.setText("Enter the correct Username/Password");
         }        
        }catch(HeadlessException | SQLException e)
        {
         JOptionPane.showMessageDialog(null, e);
        }
        
}
    
public void gotosignup()
{        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
          AnchorPane b = (AnchorPane) loader.load();
           Scene scene = new Scene(b);
                Stage stage = new Stage();
                        stage.setScene(scene);
               // stage.setResizable(false);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();  
           } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }    
}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
