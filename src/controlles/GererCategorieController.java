/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlles;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entitys.Catégorie;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.CatégorieService;

/**
 * FXML Controller class
 *
 * @author Touaibi-Alaa
 */
public class GererCategorieController implements Initializable {
    private int id;
        @FXML
    private JFXButton bLivre;
 @FXML
    private JFXButton bDashbord;
    @FXML
    private JFXButton bCat;

    @FXML
    private JFXButton bCommande;

    @FXML
    private JFXButton bReclam;

    @FXML
    private JFXButton bLivreur;

   
    @FXML
    private TableView<Catégorie> tvcategorie;
    @FXML
    private TableColumn<Catégorie, Integer> coId;
    @FXML
    private TableColumn<Catégorie, String> coLabel;
    @FXML
    private JFXTextField Label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showCategories();
    }    
public void showCategories(){
                CatégorieService s1 =new CatégorieService();

    ObservableList<Catégorie> list = s1.displayCategories();
    coLabel.setCellValueFactory(new PropertyValueFactory<Catégorie,String>("libelle"));
        coId.setCellValueFactory(new PropertyValueFactory<Catégorie,Integer>("idCategorie"));

tvcategorie.setItems(list);

    }
    

    @FXML
    private void addCatégorie(ActionEvent event) {
        CatégorieService s1 =new CatégorieService();
        Catégorie c = new Catégorie();
c.setLibelle(Label.getText());
s1.addCatégorie(c); 
    showCategories();
    }

    @FXML
    private void removeCategorie(ActionEvent event) {
        CatégorieService s1 =new CatégorieService();
              //  Catégorie c = new Catégorie();

s1.removeCategorie (id);
    showCategories();
    }

    @FXML
    private void updateCatégorie(ActionEvent event) {
        CatégorieService s1 =new CatégorieService();
        Catégorie c = new Catégorie();
        //tvcategorie.getSelectionModel().select(selectedRow);
        c.setLibelle(Label.getText());
s1.updateCatégorie(id,c); 
    showCategories();
    }
    @FXML
    private void handleMouseAction(MouseEvent event) {
     Catégorie c=  tvcategorie.getSelectionModel().getSelectedItem();
     
Label.setText(""+c.getLibelle());
id=c.getIdCategorie();

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
    void toDashbord(ActionEvent event) throws IOException {
Parent myNewScene = null;
      myNewScene = FXMLLoader.load(getClass().getResource("/gui/adminHome.fxml"));
      Scene scene = new Scene(myNewScene);
        Stage stage=(Stage) bDashbord.getScene().getWindow();;
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
    
    @FXML
    void toLivre(ActionEvent event) throws IOException {
        
      Parent myNewScene = null;
      myNewScene = FXMLLoader.load(getClass().getResource("/gui/gererLivre.fxml"));
      Scene scene = new Scene(myNewScene);
        Stage stage=(Stage) bLivre.getScene().getWindow();;
        stage.setScene(scene);
        stage.show();
    }
    
}
