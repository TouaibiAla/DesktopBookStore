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
public class Reclamation {
    private int idReclamation;
    private String sujet;
    private String description;
    private User idUtilisatuer;
    
    public Reclamation(){};
    public Reclamation(int idReclamation, String sujet, String description, User user) {
        this.idReclamation = idReclamation;
        this.sujet = sujet;
        this.description = description;
        this.idUtilisatuer=user;
    }

    public int getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getIdUtilisatuer() {
        return idUtilisatuer;
    }

    public void setIdUtilisatuer(User idUtilisatuer) {
        this.idUtilisatuer = idUtilisatuer;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "idReclamation=" + idReclamation + ", sujet=" + sujet + ", description=" + description + ", idUtilisatuer=" + idUtilisatuer.toString() + '}';
    }

    

   

    
    
    
}