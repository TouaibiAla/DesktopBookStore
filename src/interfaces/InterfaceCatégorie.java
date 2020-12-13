/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entitys.Catégorie;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author nadia
 */
public interface InterfaceCatégorie {
     public void addCatégorie(Catégorie c);
    // public List<Catégorie> afficherCatégorie();
     public void updateCatégorie(int idCategorie,Catégorie c);
     public void removeCategorie(int idCategorie);
     public Catégorie getCategorieId(int idCategorie);
    public ObservableList<Catégorie> displayCategories();
    public ArrayList<Catégorie> getCategorieByLibelle( String Libelle);

}
