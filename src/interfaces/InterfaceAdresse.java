/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entitys.Adresse;

/**
 *
 * @author Documents
 */
public interface InterfaceAdresse {
    public void addAdresse(Adresse a);
    public void updateAdresse(Adresse a);
    public void removeAdresse(Adresse a);
    public Adresse getAdressById(int id);
    
}
