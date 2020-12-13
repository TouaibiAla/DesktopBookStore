/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlles;

import com.jfoenix.controls.JFXButton;
import entitys.Reclamation;
import entitys.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
import javafx.stage.Stage;
import services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author Touaibi-Alaa
 */
public class ReclamationController implements Initializable {
    
     @FXML
    private JFXButton bDashbord;

    @FXML
    private JFXButton bCat;

    @FXML
    private JFXButton bCommande;

    @FXML
    private JFXButton bLivre;

    @FXML
    private JFXButton bLivreur;

    @FXML
    private TableColumn<Reclamation, String> colSujet;
    @FXML
    private TableColumn<Reclamation, String> colDescription;
    @FXML
    private TableView<Reclamation> tbReclam;
    @FXML
    private TableColumn<Reclamation, Integer> colIdReclam;
    @FXML
    private TableColumn<Reclamation, User> idUser;
    ReclamationService rs;
   
    public ReclamationController(){
        rs= new ReclamationService();
    }
    @FXML
    private JFXButton btnSupprimer;
    ObservableList<Reclamation> oblist= FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        colIdReclam.setCellValueFactory(new PropertyValueFactory<>("idReclamation"));
        colSujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        idUser.setCellValueFactory(new PropertyValueFactory<Reclamation,User>("idUtilisatuer"));
         ArrayList<Reclamation> arr=new ArrayList<>();
           arr=rs.getAllReclamations();
           System.out.println(arr);
          for(int i=0;i<arr.size();i++){
              oblist.add(arr.get(i));
          }
          tbReclam.setItems(oblist);
    } 
void tbReclam(){
        oblist.clear();
        ArrayList<Reclamation> arr=new ArrayList<>();
        arr=rs.getAllReclamations();
        for(int i=0;i<arr.size();i++){
              oblist.add(arr.get(i));
          }
          tbReclam.setItems(oblist);
    }
   
     @FXML
    void deleteReclamation(ActionEvent event) {
        Reclamation r=tbReclam.getSelectionModel().getSelectedItem();
        tbReclam.getItems().remove(tbReclam.getSelectionModel().getSelectedItem());
        rs.supprimerReclamation(r.getIdReclamation());
        tbReclam();
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
    void toLivre(ActionEvent event) throws IOException {
Parent myNewScene = null;
      myNewScene = FXMLLoader.load(getClass().getResource("/gui/gererLivre.fxml"));
      Scene scene = new Scene(myNewScene);
        Stage stage=(Stage) bLivre.getScene().getWindow();;
        stage.setScene(scene);
        stage.show();
    }

    
}
