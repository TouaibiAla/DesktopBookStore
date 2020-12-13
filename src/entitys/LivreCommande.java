/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

/**
 *
 * @author Touaibi-Alaa
 */
public class LivreCommande {
    private int idLivreCommande;
    private Livre livre;
    private Commande commande;
    private int quantite;

    public LivreCommande(Livre livre, int quantite) {
        this.livre = livre;     
        this.quantite = quantite;
    }
    public LivreCommande(){}

    public int getIdLivreCommande() {
        return idLivreCommande;
    }

    public void setIdLivreCommande(int idLivreCommande) {
        this.idLivreCommande = idLivreCommande;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "LivreCommande{" + "idLivreCommande=" + idLivreCommande + ", livre=" + livre.toString() + ", quantite=" + quantite + '}';
    }

   
}