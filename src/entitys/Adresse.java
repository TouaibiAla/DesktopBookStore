/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

/**
 *
 * @author Documents
 */
public class Adresse {
    private int idAdresse;
    private String gouvernorat;
    private String ville;
    private String rue;
    private int codePostal;

    public Adresse() {
    }

    public Adresse(int idAdresse, String gouvernorat, String ville, String rue, int codePostal) {
        this.idAdresse = idAdresse;
        this.gouvernorat = gouvernorat;
        this.ville = ville;
        this.rue = rue;
        this.codePostal = codePostal;
    }

    public int getIdAdresse() {
        return idAdresse;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public String getVille() {
        return ville;
    }

    public String getRue() {
        return rue;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setIdAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    @Override
    public String toString() {
        return   gouvernorat + " "+ ville + " " + rue + " " + codePostal ;
    }
    
    
}
