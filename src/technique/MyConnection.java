/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package technique;

/**
 *
 * @author Aymen
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyConnection {
   private String url="jdbc:mysql://localhost:3306/bookstoredb";
    private String login="root";
    private String pwd="";
    private Connection connection ;
    private static MyConnection instance;
	private MyConnection() {
		try {
                     
                    this.connection = DriverManager.getConnection(url, login, pwd);
			System.out.println("connection mrigla");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static MyConnection getInstance() {
		if(instance==null) {
			instance = new MyConnection();
		}
		
		return instance;
		
	}
	public Connection getConnection() {
		return connection;
	}
	
}
