/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

/**
 *
 * @author Aymen
 */
public class Livreur {
    private int idLivreur;
    private String nomLivreur;
    private String prenomLivreur;
    private boolean Disponibilite;

    public Livreur(String nomLivreur, String prenomLivreur){
        this.nomLivreur = nomLivreur;
        this.prenomLivreur = prenomLivreur;
        this.Disponibilite = true;
    }
    public Livreur(){
        
    }

    public int getIdLivreur() {
        return idLivreur;
    }

    public void setIdLivreur(int idLivreur) {
        this.idLivreur = idLivreur;
    }

    public String getNomLivreur() {
        return nomLivreur;
    }

    public void setNomLivreur(String nomLivreur) {
        this.nomLivreur = nomLivreur;
    }

    public String getPrenomLivreur() {
        return prenomLivreur;
    }

    public void setPrenomLivreur(String prenomLivreur) {
        this.prenomLivreur = prenomLivreur;
    }

    public boolean getDisponibilite() {
        return Disponibilite;
    }

    public void setDisponibilite(boolean Disponibilite) {
        this.Disponibilite = Disponibilite;
    }

    @Override
    public String toString() {
        return "Livreur{" + "idLivreur=" + idLivreur + ", nomLivreur=" + nomLivreur + ", prenomLivreur=" + prenomLivreur + ", Disponibilite=" + Disponibilite + '}';
    }
    
    
    
}
