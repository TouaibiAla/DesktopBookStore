package interfaces;

import entitys.Commande;
import entitys.Panier;
import entitys.User;
import java.util.ArrayList;

/**
 *
 * @author Touaibi-Alaa
 */
public interface InterfaceCommande {
    public Long addCommmande(Commande c);
    public void removeCommande(int id);
    public Commande getCommandeById(long id);
    public ArrayList<Commande>getAllCommande();
    public boolean validCommande(Panier p);
    public void updateCommande(int id,int etat);
}