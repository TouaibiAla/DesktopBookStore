/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entitys.Adresse;
import entitys.Commande;
import entitys.Livraison;
import entitys.Livreur;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Documents
 */
public interface InterfaceLivraison {
    public void addLivraison(Livraison l);
    public void removeLivraison(Livraison l);
    public void updateLivraison(Livraison l);
    public Livraison getLivraisonById(int id);
    public Livraison getLivraisonByDate(Date date);
    public List<Livraison> displayLivraison();
    public void affecterLivreurLivraison(Livreur l, Livraison lv);
    public void affecterCommandeLivraison(Commande c, Livraison lv);
    public void affecterAdresseLivraison(Adresse a, Livraison lv);
}
