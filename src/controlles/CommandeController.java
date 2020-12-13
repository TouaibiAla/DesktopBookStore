/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlles;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import entitys.Commande;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;
import services.CommandeService;
/**
 * FXML Controller class
 *
 * @author Touaibi-Alaa
 */
public class CommandeController implements Initializable {
    
        @FXML
    private JFXButton bLivre;

    @FXML
    private JFXButton bCat;

    @FXML
    private JFXButton bdashbord;

    @FXML
    private JFXButton bReclam;

    @FXML
    private JFXButton bLivreur;
    CommandeService cs;
    static Commande CommandeSelect;
    public CommandeController(){
        cs= new CommandeService();
    }
  @FXML
    private TableView<Commande> table;
      @FXML
    private TableColumn<Commande, Integer> idCommande;
      @FXML
    private TableColumn<Commande, Date> dateCommande;
       @FXML
    private TableColumn<Commande, Integer> etatCommande;
        @FXML
    private TableColumn<Commande, Float> prixCommande;
      @FXML
    private JFXTextField etatText; 
       @FXML
    private DatePicker debut;

    @FXML
    private DatePicker fin;
    ObservableList<Commande> oblist= FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        idCommande.setCellValueFactory(new PropertyValueFactory<>("idCommande"));
        dateCommande.setCellValueFactory(new PropertyValueFactory<>("date"));
        etatCommande.setCellValueFactory(new PropertyValueFactory<>("etat"));
        prixCommande.setCellValueFactory(new PropertyValueFactory<>("prixTotale"));
           ArrayList<Commande> arr=new ArrayList<>();
           arr=cs.getAllCommande();
          for(int i=0;i<arr.size();i++){
              oblist.add(arr.get(i));
          }
          table.setItems(oblist);
          table.setRowFactory(tv -> {
              TableRow<Commande> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                     Commande rowData = row.getItem();
               
                    etatText.setText(Integer.toString(rowData.getEtat()));
                }
            });
            return row ;
        });
    }
    
    void table(){
        oblist.clear();
       ArrayList<Commande> arr=new ArrayList<>();
           arr=cs.getAllCommande();
          for(int i=0;i<arr.size();i++){
              oblist.add(arr.get(i));
          }
          table.setItems(oblist);
    }
    
     @FXML
    void deleteCommande(ActionEvent event) {
       Commande c=table.getSelectionModel().getSelectedItem();
        table.getItems().remove(table.getSelectionModel().getSelectedItem());
      cs.removeCommande(c.getIdCommande());
      table();
    }
    
     @FXML
    void updateEtat(ActionEvent event) {
         Commande c=table.getSelectionModel().getSelectedItem();
         System.out.println(etatText.getText());
         cs.updateCommande(c.getIdCommande(),Integer.valueOf(etatText.getText()));
         table();
    }
    
     @FXML
    void chercher(ActionEvent event) {
           java.util.Date dated = java.util.Date.from(debut.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
           java.sql.Date debut1 = new java.sql.Date(dated.getTime());
           java.util.Date datef = java.util.Date.from(fin.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
           java.sql.Date fin1 = new java.sql.Date(datef.getTime());
           ArrayList<Commande> arr=new ArrayList<>();
           arr=cs.chercher(debut1, fin1);
            oblist.clear();
            for(int i=0;i<arr.size();i++){
              oblist.add(arr.get(i));
          }
          table.setItems(oblist);
    }
    
    @FXML
    void detailCommande(ActionEvent event) throws IOException {
     CommandeSelect=table.getSelectionModel().getSelectedItem();
        System.out.println(CommandeSelect);
        Parent root = FXMLLoader.load(getClass().getResource("/gui/detailsCommande.fxml"));
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
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
    void toDashbord(ActionEvent event) throws IOException {
 Parent myNewScene = null;
      myNewScene = FXMLLoader.load(getClass().getResource("/gui/adminhome.fxml"));
      Scene scene = new Scene(myNewScene);
        Stage stage=(Stage) bdashbord.getScene().getWindow();;
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
