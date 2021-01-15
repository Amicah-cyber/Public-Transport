/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publictransport1;

import publictransport1.Objects.Trip;
import utils.IUser;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;
import publictransport1.Objects.User;
import publictransport1.LoginController;
import utils.DBConnect;
/**
 * FXML Controller class
 *
 * @author Amix
 */
public class TicketController implements Initializable {

    @FXML
    private Label origin1;
    @FXML
    private Label dest1;
    @FXML
    private Label coach1;
    @FXML
    private Label mobile1;
    @FXML
    private Label id1;
    @FXML
    private Label time1;
    @FXML
    private Label date1;
    @FXML
    private Label full1;
      String a = null;
        String b =  null;
        String c = null;
        String d = null;
        String e = null;
        String full = null;
        String id = null;
        String mobile2 = null;
    Connection conn = DBConnect.connect();
    PreparedStatement pst = null;
 ResultSet rs = null;
    Trip trip;
     private User user = SessionManager.INSTANCE.getUser();
    
  public TicketController() { }
  
    /**
     * Initializes the controller class.
     * @param selectedtrip
     */
    public void gettripdata(Trip selectedtrip)
    {
      
        this.trip = selectedtrip;
        try{
        a = selectedtrip.getOrigin();
        b = selectedtrip.getDestination();
        c = selectedtrip.getCoach();
        d = selectedtrip.getDate().toString();
        e = selectedtrip.gettime();
        System.out.println(a + b+ c);
        origin1.setText(a);
        dest1.setText(b);
        coach1.setText(c);
        date1.setText(d);
        time1.setText(e);
        
        }catch(Exception ex)
        {
        JOptionPane.showMessageDialog(null, ex);
        }finally
        {
          
        }
    }
   public void setdata()
   {
       full = user.getfullnames();
        int Nid = user.getNid();
        id = Integer.toString(Nid);
        mobile2 = user.getmobileNo();
        full1.setText(full);
        id1.setText(id);
        mobile1.setText(mobile2);
   }
   
   public void insertdata()
   {
       if(full!=null && id !=null && mobile2 != null && a!=null&& b!=null && c !=null && d !=null && e !=null){
           
         String sql ="INSERT INTO `tickets`(`Fullnames`, `Nid`, `Mobile`,`Origin`, `Destination`, `Coach`, `Date`, `Time`) VALUES ('"+full+"','"+id+"','"+mobile2+"','"+a+"','"+b+"','"+c+"','"+d+"','"+e+"')";
            try {
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Your ticket has been saved");
            } catch (SQLException ex) {
                Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
            }
       }else
       {
       JOptionPane.showMessageDialog(null, "Invalid input, check your ticket details again");
       }
   }
   public void backButtonclicked()
   {
       
   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
