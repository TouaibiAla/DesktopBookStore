/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entitys.User;
import java.util.List;

/**
 *
 * @author Touaibi-Alaa
 */
public interface InterfaceUser {
    public void addUser(User u);
    public void updateUser(int id,User u);
    public void removeUser(int id);
    public User getUserId(int id);
    public List<User> displayUsers();
    public User login(String mail,String password); 
    public void logout();
}
