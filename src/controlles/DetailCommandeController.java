/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlles;
import entitys.Commande;
import entitys.User;
import entitys.Livre;
import entitys.LivreCommande;
import entitys.displayLivre;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.CommandeService;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Touaibi-Alaa
 */
public class DetailCommandeController implements Initializable {
    CommandeService cs;
    UserService us;
    public DetailCommandeController(){
        cs=new CommandeService();
        us=new UserService();
    }
    
 @FXML
    private TableView<displayLivre> tables;

    @FXML
    private TableColumn<displayLivre, String> nomLivre;
     @FXML
    private TableColumn<displayLivre, Integer> prix;
    @FXML
    private TableColumn<displayLivre, Integer> quantite;

   
     @FXML
    private Label nom;

    @FXML
    private Label prenom;

    @FXML
    private Label email;

    @FXML
    private Label Tel;
    ObservableList<displayLivre> oblist= FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User u=CommandeController.CommandeSelect.getUserCommande();
        nom.setText(u.getName());
        prenom.setText(u.getLastName());
        email.setText(u.getMail());
        Tel.setText(Integer.toString(u.getPhoneNumber()));
         nomLivre.setCellValueFactory(new PropertyValueFactory<>("nomLivre"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        ArrayList<LivreCommande> arr=new ArrayList<>();
        arr=cs.afficherLesLivres(CommandeController.CommandeSelect.getIdCommande());
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i).getLivre());
            oblist.add(new displayLivre(arr.get(i).getLivre().getNomLivre(), (int) arr.get(i).getLivre().getPrix(), arr.get(i).getQuantite()));
        }
        tables.setItems(oblist);
    }    
    
}
