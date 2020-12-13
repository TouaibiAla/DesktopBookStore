/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import entitys.Commande;
import entitys.Livreur;
import java.sql.Date;

/**
 *
 * @author Documents
 */
public class Livraison {
    private int idLivraison;
    private Date dateLivraison;
    private int etat;
    private Livreur idLivreur;
    private Commande idCommande;
    private Adresse idAdresse;
    private String etatstr;

    public Livraison() {
        
    }

    public Livraison(int idLivraison, Date dateLivraison, int etat, Livreur idLivreur, Commande idCommande, Adresse idAdresse) {
        this.idLivraison = idLivraison;
        this.dateLivraison = dateLivraison;
        this.etat = 0;
        this.idLivreur = idLivreur;
        this.idCommande = idCommande;
        this.idAdresse = idAdresse;
    }
 public String getEtatstr(){
        if(etat==0){
            etatstr="Non livrée";
        }
        else if(etat==1){
            etatstr="En cours";
        }
        else{
            etatstr="Livrée";
        }
        return etatstr;
    }
    public int getIdLivraison() {
        return idLivraison;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public int getEtat() {
        return etat;
    }

    public Livreur getIdLivreur() {
        return idLivreur;
    }

    public Commande getIdCommande() {
        return idCommande;
    }

    public Adresse getIdAdresse() {
        return idAdresse;
    }

    public void setIdLivraison(int idLivraison) {
        this.idLivraison = idLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setIdLivreur(Livreur idLivreur) {
        this.idLivreur = idLivreur;
    }

    public void setIdCommande(Commande idCommande) {
        this.idCommande = idCommande;
    }

    public void setIdAdresse(Adresse idAdresse) {
        this.idAdresse = idAdresse;
    }

    @Override
    public String toString() {
        return "Livraison{" + "idLivraison=" + idLivraison + ", dateLivraison=" + dateLivraison + ", etat=" + etat + ", idLivreur=" + idLivreur + ", idCommande=" + idCommande + ", idAdresse=" + idAdresse.toString() + '}';
    }

   

    
}
