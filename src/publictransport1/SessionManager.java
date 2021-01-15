/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publictransport1;
//import models.auth.User;

import publictransport1.Objects.User;

/**
 *
 * @author Amix
 */
public enum SessionManager {
    INSTANCE;
    User user;
    public User getUser()
    {
       return user;
    }
    public void setUser(User user)
    {
        this.user=user; 
    }
}
