/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author Aymen
 */
import entitys.User;
import entitys.UserSession;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import technique.MyConnection;
import interfaces.InterfaceUser;

/**
 *
 * @author saif
 */
public class UserService implements InterfaceUser{
    MyConnection connection;
    public UserService()
    {
        connection=MyConnection.getInstance();
    }
    
    @Override
    public void addUser(User u) {
        try {
            String req= "insert into user(`name`, `lastname`, `mail`, `password`, `phonenumber` , `role`, `img`) values  (?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.getConnection().prepareStatement(req);
            ps.setString(1, u.getName());
            ps.setString(2, u.getLastName());
            ps.setString(3, u.getMail());
            ps.setString(4, u.getPassWord());
            ps.setInt(5, u.getPhoneNumber());
            ps.setString(6, u.getRole().toString());
            ps.setString(7, u.getImg());
            
            ps.executeUpdate(); 
            
            System.out.println("user added successfully");
            
        } catch (SQLException ex) {
            System.err.println("add erreur");
        }
    }

    @Override
    public List<User> displayUsers() {
        List<User> usersList = new ArrayList<User>();
        try {
            String req1= "select * from user ";
            Statement s= connection.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("lastname"));
                user.setMail(rs.getString("mail"));
                user.setPassWord(rs.getString("password"));
                user.setPhoneNumber(rs.getInt("phonenumber"));
                user.setRole(rs.getString("role"));
                user.setImg(rs.getString("img"));
                usersList.add(user);
            }
            System.out.println("users display succeeded");
        } catch (SQLException ex) {
            System.err.println("display erreur");
        }
        return usersList;
    }

    @Override
    public User getUserId(int id) {
        User user = new User();
        try {
            String req1= "select * from user WHERE id = "+id;
            Statement s= connection.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("lastname"));
                user.setMail(rs.getString("mail"));
                user.setPassWord(rs.getString("password"));
                user.setPhoneNumber(rs.getInt("phonenumber"));
                user.setRole(rs.getString("role"));
                user.setImg(rs.getString("img"));
            }
            
            System.out.println("users getId succeeded");
        } catch (SQLException ex) {
            System.err.println("getid erreur");
        }
        return user;
    }

    @Override
    public void removeUser(int id) {
        try {
            String req1= "DELETE FROM `user` WHERE `user`.`id` ="+id;
            Statement s= connection.getConnection().createStatement();
            int rs = s.executeUpdate(req1);
            System.out.println("users remove succeeded");
        } catch (SQLException ex) {
            System.err.println("users remove erreur");
        }
    }

    @Override
    public void updateUser(int id, User u) {
        try {
            String req1= "UPDATE `user` SET `name` = ?, `lastname` = ?, `mail` = ?, `password` = ?, `phonenumber` = ?,`img` = ? WHERE `user`.`id` ="+id;
            PreparedStatement ps = connection.getConnection().prepareStatement(req1);
            ps.setString(1, u.getName());
            ps.setString(2, u.getLastName());
            ps.setString(3, u.getMail());
            ps.setString(4, u.getPassWord());
            ps.setInt(5, u.getPhoneNumber());
            ps.setString(6, u.getImg());
            ps.executeUpdate(); 
            System.out.println("users update succeeded");
        } catch (SQLException ex) {
            System.err.println("users update erreur");
        }
    }

    @Override
    public User login(String mail, String password) {
        User user = new User();
         try {
            String req1= "select * from user WHERE mail like ? and password like ?";
           PreparedStatement ps = connection.getConnection().prepareStatement(req1);
            ps.setString(1, mail);
            ps.setString(2, password);
           
             ResultSet rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("lastname"));
                user.setMail(rs.getString("mail"));
                user.setPassWord(rs.getString("password"));
                user.setPhoneNumber(rs.getInt("phonenumber"));
                user.setRole(rs.getString("role"));
                user.setImg(rs.getString("img"));
            }
            if(user.getMail()!=null){
                System.out.println(user); 
                
                UserSession userSession = new UserSession();
                UserSession.getInstace(user);
                System.out.println("session created");
            }
            else{
                System.out.println("user dosen't exist");
            }
            return user; 
            
        } catch (SQLException ex) {
            System.out.println("login faild");
            System.err.println(ex);
            
        }
         
         return null ;
    }

    @Override
    public void logout() {
        UserSession.cleanUserSession();
        System.out.println("session destroyed");
    }
    
}