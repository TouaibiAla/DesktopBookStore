/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entitys.Adresse;
import entitys.Commande;
import entitys.Livraison;
import entitys.Livreur;
import interfaces.InterfaceLivraison;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import services.CommandeService;
import services.LivreurService;
import technique.MyConnection;

/**
 *
 * @author Documents
 */
public class LivraisonService implements InterfaceLivraison{

    MyConnection connection;
    public LivraisonService()
    {
        connection=MyConnection.getInstance();
    }
    @Override
    public void addLivraison(Livraison l) {
         try{
            String req= "insert into livraison(`dateLivraison`, `etat`, `idLivreur`, `idCommande`, `idAdresse`) values  (?,?,?,?,?)";
            PreparedStatement ps = connection.getConnection().prepareStatement(req);
            ps.setDate(1, l.getDateLivraison());
            ps.setInt(2, l.getEtat());
            ps.setInt(3, l.getIdLivreur().getIdLivreur());
            ps.setInt(4, l.getIdCommande().getIdCommande());
            ps.setInt(5, l.getIdAdresse().getIdAdresse());
            ps.executeUpdate(); 
            System.out.println("livraison ajoutée avec succès");
        } catch (SQLException ex) {
            System.err.println(ex);
        
        }
    }

    @Override
    public void removeLivraison(Livraison l) {
        try {
            String req="DELETE FROM livraison WHERE idLivraison=?";
            PreparedStatement ps=connection.getConnection().prepareStatement(req);
            ps.setInt(1, l.getIdLivraison());
            ps.executeUpdate();
            System.out.println("Livraison supprimée avec succées");
        } catch (SQLException ex) {
           System.err.println("Erreur de suppression");
        }
    }

    @Override
    public void updateLivraison(Livraison l) {
        try {
            String req="UPDATE livraison SET dateLivraison=? AND etat=? AND idLivreur=? AND idCommande=? AND idAdresse=?";
            PreparedStatement ps=connection.getConnection().prepareStatement(req);
            ps.setDate(1, l.getDateLivraison());
            ps.setInt(2, l.getEtat());
            ps.setInt(3, l.getIdLivreur().getIdLivreur());
            ps.setInt(4, l.getIdCommande().getIdCommande());
            ps.setInt(5, l.getIdAdresse().getIdAdresse());
            ps.executeUpdate();
            System.out.println("Livraison modifiée avec succes");
        } catch (SQLException ex) {
              System.err.println("Erreur de modification");
        }
    }

    @Override
    public Livraison getLivraisonById(int id) {
        Livraison lv= new Livraison();
        try {
            String req="SELECT * FROM livraison WHERE idLivraison="+id;
            Statement st=connection.getConnection().createStatement();
            ResultSet rs=st.executeQuery(req);
            while(rs.next()){
                lv.setIdLivraison(rs.getInt("idLivraison"));
                lv.setDateLivraison(rs.getDate("dateLivraison"));
                lv.setEtat(rs.getInt("etat"));
                lv.setIdLivreur(new LivreurService().getLivreurById(rs.getInt("idLivreur")));
                lv.setIdCommande(new CommandeService().getCommandeById(rs.getInt("idCommande")));
                lv.setIdAdresse(new AdresseService().getAdressById(rs.getInt("idAdresse")));
            }
        } catch (SQLException ex) {
            System.err.println("Erreur de la méthode getLivraisonById");
        }
      return lv;
    }

    @Override
    public Livraison getLivraisonByDate(Date date) {
        Livraison lv= new Livraison();
        try {
            String req="SELECT * FROM livraison WHERE dateLivraison="+date;
            Statement st=connection.getConnection().createStatement();
            ResultSet rs=st.executeQuery(req);
            while(rs.next()){
                lv.setIdLivraison(rs.getInt("idLivraison"));
                lv.setDateLivraison(rs.getDate("dateLivraison"));
                lv.setEtat(rs.getInt("etat"));
                lv.setIdLivreur(new LivreurService().getLivreurById(rs.getInt("idLivreur")));
                lv.setIdCommande(new CommandeService().getCommandeById(rs.getInt("idCommande")));
                lv.setIdAdresse(new AdresseService().getAdressById(rs.getInt("idAdresse")));
            }
        } catch (SQLException ex) {
            System.err.println("Erreur de la méthode getLivraisonByDate");
        }
      return lv;
    }

    @Override
    public List<Livraison> displayLivraison() {
        ArrayList<Livraison> liv=new ArrayList<>();
        try {
            String req="SELECT * FROM livraison";
            Statement st=connection.getConnection().createStatement();
            ResultSet rs=st.executeQuery(req);
            while(rs.next()){
                Livraison lv=new Livraison();
                lv.setIdLivraison(rs.getInt("idLivraison"));
                lv.setDateLivraison(rs.getDate("dateLivraison"));
                lv.setEtat(rs.getInt("etat"));
                lv.setIdLivreur(new LivreurService().getLivreurById(rs.getInt("idLivreur")));
                lv.setIdCommande(new CommandeService().getCommandeById(rs.getInt("idCommande")));
                lv.setIdAdresse(new AdresseService().getAdressById(rs.getInt("idAdresse")));
                liv.add(lv);
            }
        } catch (SQLException ex) {
           System.err.println("Lister toutes les livraisons");
        }
        return liv;
    }

    @Override
    public void affecterLivreurLivraison(Livreur l, Livraison lv) {
        try{
            String req= "insert into livraison(`dateLivraison`,`etat`, `idLivreur`, `idCommande`, `idAdresse`) values  (?,?,?,?,?)";
            PreparedStatement ps = connection.getConnection().prepareStatement(req);
            ps.setDate(1, lv.getDateLivraison());
            ps.setInt(2, lv.getEtat());
            ps.setInt(3, l.getIdLivreur());
            ps.setInt(4, lv.getIdCommande().getIdCommande());
            ps.setInt(5, lv.getIdAdresse().getIdAdresse());
            ps.executeUpdate(); 
            System.out.println("livreur affecté avec succès");
            
        } catch (SQLException ex) {
            System.err.println("Erreur d'affectation");
        }
    }

    @Override
    public void affecterCommandeLivraison(Commande c, Livraison lv) {
        try{
            String req= "insert into livraison(`dateLivraison`, `etat`,`idLivreur`, `idCommande`, `idAdresse`) values  (?,?,?,?,?)";
            PreparedStatement ps = connection.getConnection().prepareStatement(req);
            ps.setDate(1, lv.getDateLivraison());
            ps.setInt(2, lv.getEtat());
            ps.setInt(3, lv.getIdLivreur().getIdLivreur());
            ps.setInt(4, c.getIdCommande());
            ps.setInt(5, lv.getIdAdresse().getIdAdresse());
            ps.executeUpdate(); 
            System.out.println("Commande affectée avec succès");
            
        } catch (SQLException ex) {
            System.err.println("Erreur d'affectation");
        }
    }

    @Override
    public void affecterAdresseLivraison(Adresse a, Livraison lv) {
        try{
            String req= "insert into livraison(`dateLivraison`, `etat`,`idLivreur`, `idCommande`, `idAdresse`) values  (?,?,?,?,?)";
            PreparedStatement ps = connection.getConnection().prepareStatement(req);
            ps.setDate(1, lv.getDateLivraison());
            ps.setInt(2, lv.getEtat());
            ps.setInt(3, lv.getIdLivreur().getIdLivreur());
            ps.setInt(4, lv.getIdCommande().getIdCommande());
            ps.setInt(5, a.getIdAdresse());
            ps.executeUpdate(); 
            System.out.println("Adresse affecrée avec succès");
            
        } catch (SQLException ex) {
            System.err.println("Erreur d'affectation");
        }
    }
    AdresseService as=new AdresseService();
    LivreurService ls=new LivreurService();
    CommandeService cs=new CommandeService();
    
    public ArrayList<Livraison> getLivraisonsByLivreur(Livreur l){
        ArrayList<Livraison> ListeLivraisons = new ArrayList<Livraison>();
        try {
            String req1= "select * from livraison where idLivreur="+l.getIdLivreur();
            Statement s= connection.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                Livraison livraison = new Livraison();
                livraison.setIdLivraison(rs.getInt("idLivraison"));
                livraison.setDateLivraison(rs.getDate("dateLivraison"));
                livraison.setEtat(rs.getInt("etat"));
                livraison.setIdLivreur(ls.getLivreurById(rs.getInt("idLivreur")));
                livraison.setIdAdresse(as.getAdressById(rs.getInt("idAdresse")));
                livraison.setIdCommande(cs.getCommandeById(rs.getInt("idCommande")));
                ListeLivraisons.add(livraison);
            }
            System.out.println("Méthode getLivraisonsByLivreur fonctionne correctement");
        } catch (SQLException ex) {
            System.err.println("Erreur de la méthode getLivraisonsByLivreur");
        }
        return ListeLivraisons;
    }
    public void terminerLivraison(Livraison l){
        try {
            String req1= "UPDATE `livraison` SET `etat` = 2 WHERE `livraison`.`idLivraison` ="+l.getIdLivraison();
            PreparedStatement ps = connection.getConnection().prepareStatement(req1);
            ps.executeUpdate(); 
            System.out.println("Livraison terminé");
        } catch (SQLException ex) {
            System.err.println("Erreur fonction terminerLivraison");
        }
    }
    
    public void commencerLivraison(Livraison l){
        try {
            String req1= "UPDATE `livraison` SET `etat` = 1 WHERE `livraison`.`idLivraison` ="+l.getIdLivraison();
            PreparedStatement ps = connection.getConnection().prepareStatement(req1);
            ps.executeUpdate(); 
            System.out.println("Livraison en cours");
        } catch (SQLException ex) {
            System.err.println("Erreur fonction commencerLivraison");
        }
    }

}
