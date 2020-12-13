/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entitys.Livreur;
import java.util.ArrayList;

/**
 *
 * @author Aymen
 */
public interface InterfaceLivreur {
    public void ajouterLivreur(Livreur l);
    public void modifierLivreur(Livreur l);
    public void supprimerLivreur(Livreur l);
    public ArrayList<Livreur> getAllLivreurs();
    public ArrayList<Livreur> getLivreurByNom(String nom);
    public ArrayList<Livreur> getLivreurByPrenom(String prenom);
    public ArrayList<Livreur> getLivreursByDisponibilite(boolean b);
    public Livreur getLivreurById(int id);
}
