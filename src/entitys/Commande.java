/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import java.sql.Date;





/**
 *
 * @author Touaibi-Alaa
 */
public class Commande {
   
    private int idCommande;
    private Date date;
    private int etat;
    private float prixTotale;
    private User userCommande;
    public Commande(){};
    public Commande(Date date, int etat, float prixTotale, User userCommande) {
        this.date = date;
        this.etat = etat;
        this.prixTotale = prixTotale;
        this.userCommande = userCommande;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public float getPrixTotale() {
        return prixTotale;
    }

    public void setPrixTotale(float prixTotale) {
        this.prixTotale = prixTotale;
    }

    public User getUserCommande() {
        return userCommande;
    }

    public void setUserCommande(User userCommande) {
        this.userCommande = userCommande;
    }

    @Override
    public String toString() {
        return "code= "+idCommande + "," + date + "," + etat + "," + prixTotale + ", userCommande=" + userCommande + '}';
    }
    
    
}