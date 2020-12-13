/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import java.util.ArrayList;

/**
 *
 * @author Touaibi-Alaa
 */
public class Panier {
    private int idPanier;
    private float prixTotale;
    private boolean valide;
    ArrayList<LivreCommande> listLivre;
    private User user;
    public Panier(){
        listLivre=new ArrayList<>();
        this.valide=false;
    }
    public Panier(int idPanier, float prixTotale) {
        this.idPanier = idPanier;
        this.prixTotale = prixTotale;
         listLivre=new ArrayList<>();
         this.valide=false;
    }
    public Panier(User user){
        listLivre=new ArrayList<>();
         this.valide=false;
         this.user=user;
    }
    public int getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public float getPrixTotale() {
        return prixTotale;
    }

    public void setPrixTotale(float prixTotale) {
        this.prixTotale = prixTotale;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public ArrayList<LivreCommande> getListLivre() {
        return listLivre;
    }

    public void setListLivre(ArrayList<LivreCommande> listLivre) {
        this.listLivre = listLivre;
    }
    public boolean addLivre(LivreCommande e){
        this.prixTotale+=e.getLivre().getPrix()*e.getQuantite();
        return this.listLivre.add(e);
    }
    public boolean removeLivre(LivreCommande e){
        this.prixTotale-=e.getLivre().getPrix()*e.getQuantite();
        return this.listLivre.remove(e);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Panier{" + "idPanier=" + idPanier + ", prixTotale=" + prixTotale + ", valide=" + valide + ", listLivre=" + listLivre + ", user=" + user.toString() + '}';
    }
    
    
    
    
    
}