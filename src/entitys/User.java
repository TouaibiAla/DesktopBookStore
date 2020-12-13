/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import entitys.UserRole.Role;

/**
 *
 * @author Aymen
 */
public class User {
    private int id ;
    private String name;
    private String lastName;
    private String mail;
    private String passWord;
    private int phoneNumber;
    private Role role ;  
    private String img;
    public User() {
    }

    public User( String name, String lastName, String mail, String passWord, int phoneNumber, Role role, String img) {
        
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.img = img;
    }

   

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    public Role getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = Role.valueOf(role);
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public String getPassWord() {
        return passWord;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + lastName ;
    }
}
