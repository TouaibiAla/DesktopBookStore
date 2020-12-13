/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopbookstore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import root.Roots;

/**
 *
 * @author Touaibi-Alaa
 */
public class DesktopBookStore extends Application {
    
     @Override
    public void start(Stage stage) throws Exception {
        Parent rootLogin = FXMLLoader.load(getClass().getResource("/gui/loggin.fxml"));
        Parent rootInscription = FXMLLoader.load(getClass().getResource("/gui/inscription.fxml"));
        Parent rootAdminHome = FXMLLoader.load(getClass().getResource("/gui/adminHome.fxml"));
        Parent rootClientHome = FXMLLoader.load(getClass().getResource("/gui/clientHome.fxml"));
        Parent rootLivreurHome = FXMLLoader.load(getClass().getResource("/gui/livreurHome.fxml"));
        Roots.rootMap.put("login", rootLogin);
        Roots.rootMap.put("inscription", rootInscription);
        Roots.rootMap.put("adminHome", rootAdminHome);
        Roots.rootMap.put("clientHome", rootClientHome);
        Roots.rootMap.put("livreurHome", rootLivreurHome);
        
        Roots.showStage("login");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
