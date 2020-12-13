/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlles;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import root.Roots;
import services.LivreService;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Aymen
 */
public class AdminHomeController implements Initializable {
    
       @FXML
    private JFXButton bLivre;

    @FXML
    private JFXButton bCat;

    @FXML
    private JFXButton bCommande;

    @FXML
    private JFXButton bReclam;

    @FXML
    private JFXButton bLivreur;
    @FXML
    private JFXTextField userNumber;
    @FXML
    private JFXTextField bookNumber;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    private void logout(ActionEvent event) {
        UserService userService = new UserService();
        userService.logout();
        Roots.stage.close();
    }
    
    @FXML
    void toCategorie(ActionEvent event) throws IOException {
 Parent myNewScene = null;
      myNewScene = FXMLLoader.load(getClass().getResource("/gui/gererCategorie.fxml"));
      Scene scene = new Scene(myNewScene);
        Stage stage=(Stage) bCat.getScene().getWindow();;
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void toCommande(ActionEvent event) throws IOException {
 Parent myNewScene = null;
      myNewScene = FXMLLoader.load(getClass().getResource("/gui/commande.fxml"));
      Scene scene = new Scene(myNewScene);
        Stage stage=(Stage) bCommande.getScene().getWindow();;
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void toLivre(ActionEvent event) throws IOException {
        
 Parent myNewScene = null;
      myNewScene = FXMLLoader.load(getClass().getResource("/gui/gererLivre.fxml"));
      Scene scene = new Scene(myNewScene);
        Stage stage=(Stage) bLivre.getScene().getWindow();;
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void toLivreur(ActionEvent event) throws IOException {
 Parent myNewScene = null;
      myNewScene = FXMLLoader.load(getClass().getResource("/gui/gererLivreur.fxml"));
      Scene scene = new Scene(myNewScene);
        Stage stage=(Stage) bLivreur.getScene().getWindow();;
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void toReclam(ActionEvent event) throws IOException {
 Parent myNewScene = null;
      myNewScene = FXMLLoader.load(getClass().getResource("/gui/reclamation.fxml"));
      Scene scene = new Scene(myNewScene);
        Stage stage=(Stage) bReclam.getScene().getWindow();;
        stage.setScene(scene);
        stage.show();
    }
    
}
