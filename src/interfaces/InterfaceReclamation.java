/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entitys.Reclamation;
import java.util.ArrayList;



/**
 *
 * @author Touaibi-Alaa
 */
public interface InterfaceReclamation {
     public void ajouterReclamation(Reclamation r);
    public void modifierReclamation(Reclamation r);
    public void supprimerReclamation(int id);
    public ArrayList<Reclamation> getAllReclamations();
    public Reclamation getReclamationById(int id);
}