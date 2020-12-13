/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

/**
 *
 * @author nadia
 */
public class Catégorie {
    private int idCategorie;
    private String libelle;
    public Catégorie( String libelle) {
      
        this.libelle = libelle;
    }

    public Catégorie() {
    }
    

    public int getIdCategorie() {
        return idCategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return  libelle;
    }
    
    
}
