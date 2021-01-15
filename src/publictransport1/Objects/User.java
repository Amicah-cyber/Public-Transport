/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publictransport1.Objects;

import publictransport1.LoginController;
import publictransport1.TicketController;
import utils.IUser;

/**
 *
 * @author Amix
 */
public final class User {
   
 /*  TicketController tick;

    public User() {
        tick = new TicketController(new LoginController());
    }
*/
  private  String username;
    private String fullnames;
   private String mobileNo;
   private int Nid;
    private String password;
    public static User user;
    
    private User( String fullnames, String username, int Nid, String mobileNo, String password) {
       
        this.fullnames = fullnames;
        this.username = username;
        this.Nid = Nid;
        this.mobileNo = mobileNo;
        this.password = password;
        
    }
    private User(String fullnames, String mobileNo, int Nid)
    {
        this.fullnames=fullnames;
        this.mobileNo=mobileNo;
        this.Nid=Nid;
    }
   public static User setUseratt( String fullnames,String mobileNo, int Nid)
   {
       if(user==null)
       { user = new User(fullnames,mobileNo,Nid);}
     return user;
   }
    public String getfullnames() {
        return fullnames;
    }

 
    public void setfullnames(String fullnames) {
        this.fullnames = fullnames;
    }

    public String getusername() {
        return username;
    }


    public void setusername(String username) {
        this.username = username;
    }
 
     public int getNid() {
        return Nid;
    }
     
 
    public void setNid(int Nid) {
        this.Nid = Nid;
    }
    
    public String getmobileNo(){
        return mobileNo;
    }
  
    public void setmobileNo(String mobileNo){
        this.mobileNo = mobileNo;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
