/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlles;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entitys.User;
import entitys.UserSession;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import root.Roots;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author saif
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField mail;

   @FXML
    private JFXPasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) {
        UserService userService = new UserService();
        User user = userService.login(mail.getText(), password.getText());
        UserSession.getInstace(user);
        
        if (UserSession.getInstance().getMail()!=null) {
            System.out.println("user authonticated");
            if(UserSession.getInstance().getRole().toString()=="ADMIN"){
                Roots.showStage("adminHome");
            }
            else if(UserSession.getInstance().getRole().toString()=="CLIENT"){
                Roots.showStage("clientHome");
            }
            else{
                Roots.showStage("livreurHome");
            }
        }
        else{
            System.out.println("user dosne't exist controller");
        }
        
        
    }

    @FXML
    private void openInscription(ActionEvent event) throws IOException {
        Roots.showStage("inscription");
        
    }
     @FXML
    private void toLivreur(ActionEvent event) throws IOException {
        Parent myNewScene = null;
        myNewScene = FXMLLoader.load(getClass().getResource("/gui/livreurLivraison.fxml"));
         Scene scene = new Scene(myNewScene);
        Stage stage=(Stage) mail.getScene().getWindow();;
        stage.setScene(scene);
        stage.show();
        
    }
    
}
