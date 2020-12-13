/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

/**
 *
 * @author Aymen
 */
public class UserSession {
    
    private static UserSession instance;

    private int id ;
    private String name;
    private String lastName;
    private String mail;
    private String passWord;
    private int phoneNumber;
    private UserRole.Role role ;  
    private String img;
    public UserRole.Role getRole() {
        return role;
    }

    public void setRole(UserRole.Role role) {
        this.role = role;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public static void setInstance(UserSession instance) {
        UserSession.instance = instance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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

    public UserSession(int id, String name, String lastName, String mail, String passWord, int phoneNumber, UserRole.Role role, String img) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.img = img;
    }

    

  

    public UserSession() {
    }

   public static UserSession getInstance() {
        return instance;
    }

    public static UserSession getInstace(User u) {
        if(instance == null) {
            instance = new UserSession(u.getId(),  u.getName(),  u.getLastName(),  u.getMail(),  u.getPassWord(),  u.getPhoneNumber(),u.getRole(),u.getImg());
        }
        return instance;
    }
    
    public static void cleanUserSession() {
        instance = new UserSession();
    }

    @Override
    public String toString() {
        return "UserSession{" + "id=" + id + ", name=" + name + ", lastName=" + lastName + ", mail=" + mail + ", passWord=" + passWord + ", phoneNumber=" + phoneNumber + ", role=" + role + ", img=" + img + '}';
    }
}
