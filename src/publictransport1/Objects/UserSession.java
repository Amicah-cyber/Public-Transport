/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publictransport1.Objects;

/**
 *
 * @author Amix
 */
public final class UserSession {
    private static UserSession instance;
    private User user;
    
    public static UserSession getinstance(User user)
    {
    return instance;
    }
    
}
