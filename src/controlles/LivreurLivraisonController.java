/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlles;

import entitys.Adresse;
import entitys.Commande;
import entitys.Livraison;
import entitys.Livreur;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.LivraisonService;
import services.LivreurService;

/**
 * FXML Controller class
 *
 * @author Touaibi-Alaa
 */
public class LivreurLivraisonController implements Initializable {

    @FXML
    private TableColumn<Livraison, Integer> colidlivraison;
    @FXML
    private TableView<Livraison> tvlivraisons;
    @FXML
    private TableColumn<Livraison, Date> coldatelivraison;
    @FXML
    private TableColumn<Livraison, Adresse> coladresse;
    @FXML
    private TableColumn<Livraison, String> coletat;
    @FXML
    private TableColumn<Livraison, Commande> colcommande;

    /**
     * Initializes the controller class.
     */
    LivreurService ls=new LivreurService();
    LivraisonService lvs=new LivraisonService();
    private int id;
    Livreur lv=ls.getLivreurById(1);
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherLivraisons();
    }    

    @FXML
    private void handleMouseAction(MouseEvent event) {
        Livraison l=tvlivraisons.getSelectionModel().getSelectedItem();
        id=l.getIdLivraison();
    }

    @FXML
    private void commencerLivraison(ActionEvent event) {
        Livraison  lv=tvlivraisons.getSelectionModel().getSelectedItem();
        lvs.commencerLivraison(lv);
        afficherLivraisons();
    }

    @FXML
    private void terminerLivraison(ActionEvent event) {
        Livraison  lv=tvlivraisons.getSelectionModel().getSelectedItem();
        lvs.terminerLivraison(lv);
        afficherLivraisons();
    }
    public void afficherLivraisons(){
        ObservableList<Livraison> oblist= FXCollections.observableArrayList();
        ArrayList<Livraison> arr=lvs.getLivraisonsByLivreur(lv);
        for(int i=0;i<arr.size();i++){
              oblist.add(arr.get(i));
        }
        colidlivraison.setCellValueFactory(new PropertyValueFactory<Livraison,Integer>("idLivraison"));
        coldatelivraison.setCellValueFactory(new PropertyValueFactory<Livraison,Date>("dateLivraison"));
        coletat.setCellValueFactory(new PropertyValueFactory<Livraison,String>("etatstr"));
        coladresse.setCellValueFactory(new PropertyValueFactory<Livraison,Adresse>("idAdresse"));
        colcommande.setCellValueFactory(new PropertyValueFactory<Livraison,Commande>("idCommande"));
        tvlivraisons.setItems(oblist);
        
    }
    
}
