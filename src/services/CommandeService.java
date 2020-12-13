package services;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import entitys.Commande;
import entitys.Livre;
import entitys.LivreCommande;
import entitys.Panier;
import interfaces.InterfaceCommande;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import technique.MyConnection;

/**
 *
 * @author Touaibi-Alaa
 */
public class CommandeService implements InterfaceCommande{
 MyConnection connection;
 UserService us;
     public CommandeService()
     {
        connection=MyConnection.getInstance();
        us=new UserService();
     }
    @Override
    public Long addCommmande(Commande c) {
          

        Long id=(long)-1;
     try {
         
         String req="insert into commande(`date`,`etat`,`prixTotale`,`userCommande`) values (?,?,?,?)";
         PreparedStatement ps=connection.getConnection().prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
         ps.setDate(1,c.getDate());
         ps.setInt(2, c.getEtat());
         ps.setFloat(3, c.getPrixTotale());
         ps.setInt(4, c.getUserCommande().getId());
         ps.executeUpdate();
         ResultSet rs= ps.getGeneratedKeys();
            if (rs.next()) 
            {
             id=rs.getLong(1);
            }  
            System.out.println("commande ajoute avec succes");
     } catch (SQLException ex) {
        System.err.println(ex);
     }
     return id;
    }

    @Override
    public void removeCommande(int id) {
        try {
            String req1= "delete from commande where idCommande="+id;
            Statement s= connection.getConnection().createStatement();
            s.executeUpdate(req1);
            System.out.println("commande supprime");
        } catch (SQLException ex) {
            System.err.println("commande supprime erreur");
        }
    }

    @Override
    public Commande getCommandeById(long id) {
      Commande c=new Commande();
        try {
            String req="select * from commande where idCommande="+id;
            Statement st=connection.getConnection().createStatement();
            ResultSet rs=st.executeQuery(req);
            while(rs.next()){
                c.setIdCommande(rs.getInt("idCommande"));
                c.setEtat(rs.getInt("etat"));
                c.setDate(rs.getDate("date"));
                c.setPrixTotale(rs.getFloat("prixTotale"));
                c.setUserCommande(us.getUserId(rs.getInt("userCommande")));
            }
        } catch (SQLException ex) {
            System.err.println("commande par id erreur");
        }
      return c;
    }

    @Override
    public ArrayList<Commande> getAllCommande() {
        ArrayList<Commande> arr=new ArrayList<>();
        try {
            String req="select * from commande";
            Statement st=connection.getConnection().createStatement();
            ResultSet rs=st.executeQuery(req);
            while(rs.next()){
                Commande c=new Commande();
                c.setIdCommande(rs.getInt("idCommande"));
                c.setEtat(rs.getInt("etat"));
                c.setDate(rs.getDate("date"));
                c.setPrixTotale(rs.getFloat("prixTotale"));
                c.setUserCommande(us.getUserId(rs.getInt("userCommande")));
                arr.add(c);
             
            }
            System.out.println("liste des commandes avec succes");
        } catch (SQLException ex) {
           System.err.println("Lister tous les commandes erreur");
        }
        return arr;
    }

    @Override
    public boolean validCommande(Panier p) {
            

        boolean test=true;
       if(p.isValide()){
         try {
             java.util.Date date=new java.util.Date();
             Date d=new Date(date.getTime());
             long idCommande=this.addCommmande(new Commande(d,0,p.getPrixTotale(),p.getUser()));
             
              try {
         connection.getConnection().setAutoCommit(false);
     } catch (SQLException ex) {
          System.err.println("auto commit erreur");
     }
             for(int i=0;i<p.getListLivre().size();i++){
                 try {
                     LivreCommande lc=p.getListLivre().get(i);
                     lc.setCommande(getCommandeById(idCommande));
                     String req="insert into livrecommande(idLivre,`idCommande`,`quantite`) values(?,?,?)";
                     PreparedStatement ps=connection.getConnection().prepareStatement(req);
                     ps.setInt(1,lc.getLivre().getIdLivre());
                     ps.setInt(2, lc.getCommande().getIdCommande());
                     ps.setInt(3, lc.getQuantite());
                     ps.executeUpdate();
                     System.out.println(" ajout dans livre commande avec succes");
                 } catch (SQLException ex) {
                     System.err.println("livre commande erreur");
                     try {
                         connection.getConnection().rollback();
                     } catch (SQLException ex1) {
                         System.err.println("Roolback erreur");
                     }
                     return false;
                 }
             }
             connection.getConnection().commit();
             connection.getConnection().setAutoCommit(true);
             
         } catch (SQLException ex) {
             System.err.println("commit erreur");
         }
          return true;
       }
       else return false;
       
    }

    @Override
    public void updateCommande(int id, int etat) {
          try {
            String req="update commande set etat=? where idCommande=?";
            PreparedStatement ps=connection.getConnection().prepareStatement(req);
            ps.setInt(1, etat);
            ps.setInt(2,id);
            System.out.println(ps);
            ps.executeUpdate();
            System.out.println("update commande avec succes");
        } catch (SQLException ex) {
              System.err.println("update commande erreur");
        }
    }
    
    public ArrayList<Commande>chercher(Date d, Date f){
          ArrayList<Commande> arr=new ArrayList<>();
        try{
         String req="select * from commande where date between ? and ?";
            PreparedStatement ps=connection.getConnection().prepareStatement(req);
            ps.setDate(1, d);
            ps.setDate(2,f);
            System.out.println(ps);
             ResultSet rs=ps.executeQuery();
              while(rs.next()){
                Commande c=new Commande();
                c.setIdCommande(rs.getInt("idCommande"));
                c.setEtat(rs.getInt("etat"));
                c.setDate(rs.getDate("date"));
                c.setPrixTotale(rs.getFloat("prixTotale"));
                c.setUserCommande(us.getUserId(rs.getInt("userCommande")));
                arr.add(c);
            }
              
            System.out.println("chercher commande avec succes");
        } catch (SQLException ex) {
              System.err.println("chercher commande erreur");
        }
        return arr;
    }
    
    public ArrayList<LivreCommande> afficherLesLivres(int idCommnade){
        LivreService ls=new LivreService();
          ArrayList<LivreCommande> arr=new ArrayList<>();
        try {
            String req="select * from livrecommande where idCommande="+idCommnade;
            Statement st=connection.getConnection().createStatement();
            ResultSet rs=st.executeQuery(req);
            while(rs.next()){
                LivreCommande lc=new LivreCommande();
                lc.setIdLivreCommande(rs.getInt("id"));
                lc.setQuantite(rs.getInt("quantite"));
                lc.setLivre(ls.getLivreId(rs.getInt("idLivre")));
                arr.add(lc);  
            }
            System.out.println("liste des livres dans la commande avec succes");
        } catch (SQLException ex) {
           System.err.println("liste des livres dans la commande erreur");
        }
        return arr;
    }
    
}